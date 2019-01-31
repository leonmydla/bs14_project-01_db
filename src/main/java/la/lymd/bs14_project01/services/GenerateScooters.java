package la.lymd.bs14_project01.services;

import la.lymd.bs14_project01.config.GuidelineConfig;
import la.lymd.bs14_project01.config.ScooterTypeDefinition;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateScooters {
    private final List<ScooterTypeDefinition> scooterTypes;
    private final GuidelineConfig conf;
    private final GenerateScooterTypes genTypes;

    public GenerateScooters(
            GuidelineConfig conf,
            GenerateScooterTypes genTypes
    ) {
        scooterTypes = new ArrayList<>();
        scooterTypes.add(conf.getType1());
        scooterTypes.add(conf.getType2());
        scooterTypes.add(conf.getType3());
        scooterTypes.add(conf.getType4());

        this.conf = conf;
        this.genTypes = genTypes;
    }

    void generate() {
        scooterTypes.forEach(this::generateTypes);
        generateScooters();
    }

    private void generateTypes(ScooterTypeDefinition definition) {
        genTypes.generateScooterType(definition.getName(), definition.getParts());
    }

    private void generateScooters() {
        ScooterTypeDefinition
    }


}
