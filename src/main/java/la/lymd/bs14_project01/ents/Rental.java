package la.lymd.bs14_project01.ents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class Rental extends AbstractPersistable<Long> {

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
