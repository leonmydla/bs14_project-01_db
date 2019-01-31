package la.lymd.bs14_project01.services;

import la.lymd.bs14_project01.config.ScooterTypeDefinition;
import la.lymd.bs14_project01.entities.scooter.ScooterRepository;
import la.lymd.bs14_project01.entities.scooter.price.ScooterPrice;
import la.lymd.bs14_project01.entities.scooter.price.ScooterPriceRepository;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class GenerateScooterPrices {

    private final ScooterPriceRepository priceRepo;
    private final ScooterRepository scooterRepo;
    private final int priceTimeMarginInDays = 50 * 24 * 60 * 60 * 1000;

    public GenerateScooterPrices(
            ScooterRepository scooterRepo,
            ScooterPriceRepository priceRepo
    ) {
        this.scooterRepo = scooterRepo;
        this.priceRepo = priceRepo;
    }

    public void generateScooterPrice(ScooterTypeDefinition definition, ScooterType type) {
        Date startDate = scooterRepo.findByTypeOrderByJoinedFleet(type).get(0).getJoinedFleet();
        Date workingDate = startDate;
        Date maxDate = new Date();

        while (workingDate.after(maxDate)) {
            ScooterPrice price = new ScooterPrice();
            price.setType(type);
            price.setStart(workingDate);
            price.setHourlyPrice(fluctuate(definition.getPrice()));
            price.setHalfdayDiscount(fluctuate(definition.getHalfDayDiscount()));
            price.setFulldayDiscount(fluctuate(definition.getFullDayDiscount()));
            price.setThreedayDiscount(fluctuate(definition.getThreeDayDiscount()));
            price.setWeekDiscount(fluctuate(definition.getWeekDiscount()));

            priceRepo.save(price);

            workingDate = new Date(workingDate.getTime() + priceTimeMarginInDays);
        }
    }

    private double fluctuate(double val) {
        double min = val * 0.9;
        double max = val * 1.1;
        double rand = new Random().nextDouble();

        return min + (max - min) * rand;
    }
}
