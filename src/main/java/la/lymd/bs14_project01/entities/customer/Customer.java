package la.lymd.bs14_project01.entities.customer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Date;

//@Entity
@Getter
@Setter
public class Customer extends AbstractPersistable<Long> {

    private String firstname;

    private String surname;

    private Date dateOfBirth;

    private String country;

    private String state;

    private String city;

    private long zipCode;

    private String street;

    private long streetNumber;
}
