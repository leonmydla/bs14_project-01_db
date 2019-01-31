package la.lymd.bs14_project01.entities.district;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class District extends AbstractPersistable {

    private String country;

    private String state;

    private String city;
}
