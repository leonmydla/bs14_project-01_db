package la.lymd.bs14_project01.entities.scooter;

import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import java.util.List;

public interface ScooterRepository extends DataTablesRepository<Scooter, Long> {
    List<Scooter> findByTypeOrderByJoinedFleet(ScooterType type);
}
