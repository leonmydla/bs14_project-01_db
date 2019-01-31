package la.lymd.bs14_project01.entities.reservation;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.rental.Rental;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class Reservation extends AbstractPersistable {

    @ManyToOne
    private Rental rental;

    private Date bookingTime;
}
