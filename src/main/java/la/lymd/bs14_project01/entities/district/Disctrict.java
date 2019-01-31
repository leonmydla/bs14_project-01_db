package la.lymd.bs14_project01.entities.district;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Disctrict extends AbstractPersistable<Long> {

    private String country;

    private String state;

    private String city;
}
