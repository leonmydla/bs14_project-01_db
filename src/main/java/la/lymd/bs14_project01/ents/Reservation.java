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
public class Reservation extends AbstractPersistable<Long> {

    @ManyToOne
    private Rental rental;

    private Date bookingTime;
}
