package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cocina")
public class CocinaEntity extends AreaEntity {
    public CocinaEntity() {
    }

    public CocinaEntity(Integer areaId) {
        super(areaId);
    }
}
