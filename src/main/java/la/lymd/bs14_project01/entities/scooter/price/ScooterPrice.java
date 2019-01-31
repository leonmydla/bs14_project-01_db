package la.lymd.bs14_project01.entities.scooter.price;

import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

//@Entity
@Getter
@Setter
public class ScooterPrice extends AbstractPersistable<Long> {

    @ManyToOne
    private ScooterType type;

    private Date start;

    private Date end;

    private float hourlyPrice;

    private float halfdayDiscount;

    private float fulldayDiscount;

    private float threedayDiscount;

    private float weekDiscount;
}
