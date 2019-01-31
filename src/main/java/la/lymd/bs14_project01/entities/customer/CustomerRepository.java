package la.lymd.bs14_project01.entities.customer;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface CustomerRepository extends DataTablesRepository<Customer, Long> {
}
