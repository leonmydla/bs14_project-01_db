package la.lymd.bs14_project01.entities.scooter.part;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ScooterTypePart extends AbstractPersistable {

    private String name;
}
