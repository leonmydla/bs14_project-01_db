package la.lymd.bs14_project01.entities.scooter;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.district.District;
import la.lymd.bs14_project01.entities.scooter.option.ScooterOption;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Scooter extends AbstractPersistable {

    @ManyToOne
    private ScooterType type;

    @ManyToMany
    @JoinTable(name = "scooter_to_scooter_option")
    private List<ScooterOption> options;

    private int productionYear;

    private Date joinedFleet;

    @ManyToOne
    private District district;

    private boolean deployed;

    private String location;
}
