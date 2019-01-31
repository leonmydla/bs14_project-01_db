package la.lymd.bs14_project01.services;

import la.lymd.bs14_project01.config.ScooterTypeDefinition;
import la.lymd.bs14_project01.entities.scooter.ScooterRepository;
import la.lymd.bs14_project01.entities.scooter.price.ScooterPrice;
import la.lymd.bs14_project01.entities.scooter.price.ScooterPriceRepository;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
public class GenerateScooterPrices {

    private final ScooterPriceRepository priceRepo;
    private final ScooterRepository scooterRepo;

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
            createPrice(type, workingDate, definition);

            int month = workingDate.getMonth() + 1;

            if(month >= 11) {
                month = 1;
                int year = workingDate.getYear() + 1;
                workingDate.setYear(year);
            }

            workingDate.setMonth(month);
        }
    }

    @Transactional
    protected void createPrice(ScooterType type, Date workingDate, ScooterTypeDefinition definition) {
        ScooterPrice price = new ScooterPrice();
        price.setType(type);
        price.setStart(workingDate);
        price.setHourlyPrice(fluctuate(definition.getPrice()));
        price.setHalfdayDiscount(fluctuate(definition.getHalfDayDiscount()));
        price.setFulldayDiscount(fluctuate(definition.getFullDayDiscount()));
        price.setThreedayDiscount(fluctuate(definition.getThreeDayDiscount()));
        price.setWeekDiscount(fluctuate(definition.getWeekDiscount()));

        priceRepo.save(price);
    }

    private double fluctuate(double val) {
        double min = val * 0.9;
        double max = val * 1.1;
        double rand = new Random().nextDouble();

        return min + (max - min) * rand;
    }
}
