package la.lymd.bs14_project01.entities.scooter.price;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class ScooterPrice extends AbstractPersistable {

    @ManyToOne
    private ScooterType type;

    private Date start;

    private double hourlyPrice;

    private double halfdayDiscount;

    private double fulldayDiscount;

    private double threedayDiscount;

    private double weekDiscount;
}
