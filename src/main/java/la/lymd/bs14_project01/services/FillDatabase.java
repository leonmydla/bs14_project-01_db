package la.lymd.bs14_project01.services;

import org.springframework.stereotype.Component;

@Component
public class FillDatabase {
    private final GenerateScooters generateScooters;

    public FillDatabase(GenerateScooters generateScooters) {
        this.generateScooters = generateScooters;
    }

    public void start() {
        generateScooters.generate();
    }
}
