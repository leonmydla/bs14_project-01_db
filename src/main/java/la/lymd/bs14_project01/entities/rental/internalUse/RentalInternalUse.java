package la.lymd.bs14_project01.entities.rental.internalUse;

import la.lymd.bs14_project01.entities.rental.Rental;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class RentalInternalUse extends AbstractPersistable<Long> {

    @ManyToOne
    private Rental rental;

    private String usedBy;
}
