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
public class ScooterOption extends AbstractPersistable<Long> {

    @ManyToMany
    @JoinTable(name = "scooter_to_scooter_option")
    private List<Scooter> scooters;

    private String name;
}
