package la.lymd.bs14_project01.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FillDatabase {
    private final GenerateDistricts generateDistricts;
    private final GenerateScooters generateScooters;

    public FillDatabase(
            GenerateDistricts generateDistricts,
            GenerateScooters generateScooters
    ) {
        this.generateDistricts = generateDistricts;
        this.generateScooters = generateScooters;
    }

    public void start() {
        generateDistricts.generate();
        generateScooters.generate();
    }
}
