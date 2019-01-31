package la.lymd.bs14_project01.entities.scooter.type;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import la.lymd.bs14_project01.entities.scooter.Scooter;
import la.lymd.bs14_project01.entities.scooter.part.ScooterTypePart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ScooterType extends AbstractPersistable {

    @OneToMany
    private List<Scooter> scooters;

    @ManyToMany
    @JoinTable(name = "scooter_type_to_scooter_type_part", joinColumns = {
            @JoinColumn(name = "type_id", updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "part_id", updatable = false)})
    private List<ScooterTypePart> parts;

    private String name;
}
