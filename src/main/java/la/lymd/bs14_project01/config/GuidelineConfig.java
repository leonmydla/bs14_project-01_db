package la.lymd.bs14_project01.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "guideline")
public class GuidelineConfig {

    @Setter
    private List<String> districts;
    public List<DistrictDefinition> getDistrictsList() {
        return new DistrictsDefinition(this.getDistricts()).getDistricts();
    }

    private float damagedPercent;
    private List<String> damageReasons;

    private ScooterTypeDefinition type1;
    private ScooterTypeDefinition type2;
    private ScooterTypeDefinition type3;
    private ScooterTypeDefinition type4;
}
