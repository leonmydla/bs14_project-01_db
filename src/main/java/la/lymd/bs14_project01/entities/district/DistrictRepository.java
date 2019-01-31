package la.lymd.bs14_project01.entities.district;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface DistrictRepository extends DataTablesRepository<District, Long> {

    District findOneByCountryAndStateAndCity(String country, String state, String city);
}
