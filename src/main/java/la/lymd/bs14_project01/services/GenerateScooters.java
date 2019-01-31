package la.lymd.bs14_project01.services;

import la.lymd.bs14_project01.config.GuidelineConfig;
import la.lymd.bs14_project01.config.ScooterTypeDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenerateScooters {
    private final GuidelineConfig conf;

    public GenerateScooters(GuidelineConfig conf) {
        this.conf = conf;
    }

    public void generate() {
        generateScooters(conf.getType1());
        generateScooters(conf.getType2());
        generateScooters(conf.getType3());
        generateScooters(conf.getType4());
    }

    @Transactional
    protected void generateScooters(ScooterTypeDefinition definition) {

    }

    protected void generateScooterType(String name) {

    }
}
