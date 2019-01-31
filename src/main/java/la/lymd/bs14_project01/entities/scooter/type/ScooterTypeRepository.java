package la.lymd.bs14_project01.entities.scooter.type;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface ScooterTypeRepository extends DataTablesRepository<ScooterType, Long> {
    ScooterType findOneByName(String name);
}
