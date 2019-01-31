package la.lymd.bs14_project01.services;

import la.lymd.bs14_project01.config.GuidelineConf;
import la.lymd.bs14_project01.config.ScooterTypeDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenerateScooters {
    private final GuidelineConf conf;

    public GenerateScooters(GuidelineConf conf) {
        this.conf = conf;
    }

    public void generate() {
        generateScooter(conf.getType1());
        generateScooter(conf.getType2());
        generateScooter(conf.getType3());
        generateScooter(conf.getType4());
    }

    @Transactional
    protected void generateScooter(ScooterTypeDefinition definition) {

    }
}
