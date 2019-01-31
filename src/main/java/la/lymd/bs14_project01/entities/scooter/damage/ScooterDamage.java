package la.lymd.bs14_project01.entities.scooter.damage;

import la.lymd.bs14_project01.entities.customer.Customer;
import la.lymd.bs14_project01.entities.scooter.Scooter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class ScooterDamage extends AbstractPersistable<Long> {

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Scooter scooter;


    private Date dateAndTime;

    private String description;
}
