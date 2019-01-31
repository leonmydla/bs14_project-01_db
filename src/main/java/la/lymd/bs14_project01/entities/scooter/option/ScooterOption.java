package la.lymd.bs14_project01.entities.scooter.option;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.scooter.Scooter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class ScooterOption extends AbstractPersistable {

    @ManyToMany
    @JoinTable(name = "scooter_to_scooter_option")
    private List<Scooter> scooters;

    private String name;
}
