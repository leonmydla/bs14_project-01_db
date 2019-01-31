package la.lymd.bs14_project01.services;

import la.lymd.bs14_project01.config.DistrictDefinition;
import la.lymd.bs14_project01.config.GuidelineConfig;
import la.lymd.bs14_project01.entities.district.District;
import la.lymd.bs14_project01.entities.district.DistrictRepository;
import org.springframework.stereotype.Service;

@Service
public class GenerateDistricts {

    private final GuidelineConfig conf;
    private final DistrictRepository districtRepo;

    public GenerateDistricts(
            GuidelineConfig conf,
            DistrictRepository districtRepo
    ) {
        this.conf = conf;
        this.districtRepo = districtRepo;
    }

    void generate() {
        conf.getDistrictsList().forEach(this::generateDistricts);
    }

    private void generateDistricts(DistrictDefinition definition) {
        District district = districtRepo.findOneByCountryAndStateAndCity(definition.getCountry(), definition.getState(), definition.getCity());

        if (district == null) {
            district = new District();
        }

        district.setCountry(definition.getCountry());
        district.setState(definition.getState());
        district.setCity(definition.getCity());

        districtRepo.save(district);
    }
}
