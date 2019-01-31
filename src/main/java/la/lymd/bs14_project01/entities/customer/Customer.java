package la.lymd.bs14_project01.entities.customer;

import la.lymd.bs14_project01.entities.AbstractPersistable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class Customer extends AbstractPersistable {

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
