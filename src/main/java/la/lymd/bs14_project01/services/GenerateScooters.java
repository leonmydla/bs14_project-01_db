package la.lymd.bs14_project01.services;

import com.google.common.collect.Lists;
import la.lymd.bs14_project01.config.GuidelineConfig;
import la.lymd.bs14_project01.config.ScooterTypeDefinition;
import la.lymd.bs14_project01.entities.district.District;
import la.lymd.bs14_project01.entities.district.DistrictRepository;
import la.lymd.bs14_project01.entities.scooter.Scooter;
import la.lymd.bs14_project01.entities.scooter.ScooterRepository;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import la.lymd.bs14_project01.entities.scooter.type.ScooterTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GenerateScooters {
    private final List<ScooterTypeDefinition> scooterTypes;
    private final GuidelineConfig conf;
    private final GenerateScooterTypes genTypes;
    private final GenerateScooterPrices genPrices;
    private final ScooterTypeRepository typeRepo;
    private final DistrictRepository districtRepo;
    private final ScooterRepository scooterRepo;

    public GenerateScooters(
            GuidelineConfig conf,
            GenerateScooterTypes genTypes,
            GenerateScooterPrices genPrices,
            ScooterTypeRepository typeRepo,
            DistrictRepository districtRepo,
            ScooterRepository scooterRepo
    ) {
        scooterTypes = new ArrayList<>();
        scooterTypes.add(conf.getType1());
        scooterTypes.add(conf.getType2());
        scooterTypes.add(conf.getType3());
        scooterTypes.add(conf.getType4());

        this.conf = conf;
        this.genTypes = genTypes;
        this.genPrices = genPrices;
        this.typeRepo = typeRepo;
        this.districtRepo = districtRepo;
        this.scooterRepo = scooterRepo;
    }

    void generate() {
        scooterTypes.forEach(this::generateTypes);
    }

    private void generateTypes(ScooterTypeDefinition definition) {
        ScooterType type = genTypes.generateScooterType(definition.getName(), definition.getParts());
        createScootersForType(definition, type);
        genPrices.generateScooterPrice(definition, type);
    }

    @Transactional
    protected void createScootersForType(ScooterTypeDefinition definition, ScooterType type) {
        for (int i = 0; i < definition.getTotalAmount(); i++) {
            List<District> districts = Lists.newArrayList(districtRepo.findAll());
            Collections.shuffle(districts);
            District district = districts.get(0);
            Scooter scooter = new Scooter();
            scooter.setType(type);
            scooter.setProductionYear(getYearInRange(definition.getFirstYearOfProduction(), definition.getLastYearOfProduction()));
            scooter.setJoinedFleet(getRandomDateInYearRange(definition.getFirstYearOfProduction(), definition.getLastYearOfProduction()));
            scooter.setDistrict(district);
            scooter.setDeployed(true);
            scooter.setLocation("unavailable");

            scooterRepo.save(scooter);
        }
    }

    private int getYearInRange(int from, int to) {
        return getRandomDateInYearRange(from, to).getYear();
    }

    private Date getRandomDateInYearRange(int from, int to) {
        from = from - 1900;
        to = to - 1900;
        Date fromDate = new Date(from, 0, 1);
        Date toDate = new Date(to, 11, 31);

        return new Date(ThreadLocalRandom.current()
                .nextLong(fromDate.getTime(), toDate.getTime()));
    }


}
