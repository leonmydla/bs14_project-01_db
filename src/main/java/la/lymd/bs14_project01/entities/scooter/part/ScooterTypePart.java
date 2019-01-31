package la.lymd.bs14_project01.entities.scooter.part;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class ScooterTypePart extends AbstractPersistable {

    private String name;
}
