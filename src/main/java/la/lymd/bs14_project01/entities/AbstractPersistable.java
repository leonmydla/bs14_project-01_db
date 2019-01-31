package la.lymd.bs14_project01.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPersistable implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    public boolean isNew() {
        return null == getId();
    }
}
