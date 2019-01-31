package la.lymd.bs14_project01.config;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DistrictsDefinition {

    private List<DistrictDefinition> districts;

    DistrictsDefinition(List<String> flatDistricts) {
        districts = new ArrayList<>();
        flatDistricts.forEach(this::addDistrict);
    }

    private void addDistrict(String data) {
        String[] data2D = data.split(":");

        DistrictDefinition district = new DistrictDefinition();
        district.setCountry(data2D[0]);
        district.setState(data2D[1]);
        district.setCity(data2D[2]);

        districts.add(district);
    }
}
