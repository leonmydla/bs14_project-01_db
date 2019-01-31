package la.lymd.bs14_project01.entities.scooter.type;

import la.lymd.bs14_project01.entities.scooter.part.ScooterTypePart;
import la.lymd.bs14_project01.entities.scooter.Scooter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class ScooterType extends AbstractPersistable<Long> {

    @OneToMany
    private List<Scooter> scooters;

    @ManyToMany
    @JoinTable(name = "scooter_type_to_scooter_type_part")
    private List<ScooterTypePart> parts;

    private String name;
}
