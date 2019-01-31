package la.lymd.bs14_project01.entities.rental;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.customer.Customer;
import la.lymd.bs14_project01.entities.scooter.Scooter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class Rental extends AbstractPersistable {

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Scooter scooter;

    private long hoursIncluded;

    private long kilometersIncluded;

    private Date start;

    private Date end;

    private float kilometers;
}
