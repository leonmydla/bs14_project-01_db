package la.lymd.bs14_project01.entities.rental.cancellation;

import la.lymd.bs14_project01.entities.rental.Rental;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

//@Entity
@Getter
@Setter
public class RentalCancellation extends AbstractPersistable<Long> {

    @ManyToOne()
    @JoinColumn(name = "rental_id")
    private Rental rental;

    private Date cancellationTime;
}
