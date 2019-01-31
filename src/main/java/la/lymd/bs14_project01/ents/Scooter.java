package la.lymd.bs14_project01.ents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Scooter extends AbstractPersistable<Long> {

    @ManyToOne
    private ScooterType type;

    @ManyToMany
    @JoinTable(name = "scooter_to_scooter_option")
    private List<ScooterOption> options;

    private int productionYear;

    private Date joinedFleet;

    @ManyToOne
    private Disctrict district;

    private boolean deployed;

    private String location;
}
