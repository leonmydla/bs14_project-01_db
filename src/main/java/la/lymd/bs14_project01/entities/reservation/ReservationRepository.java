package la.lymd.bs14_project01.entities.reservation;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface ReservationRepository extends DataTablesRepository<Reservation, Long> {
}
