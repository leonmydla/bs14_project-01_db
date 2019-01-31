package la.lymd.bs14_project01.ents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class ScooterTypePart extends AbstractPersistable<Long> {

    @ManyToMany
    @JoinTable(name = "scooter_type_to_scooter_type_part")
    private List<ScooterType> types;

    private String name;
}
