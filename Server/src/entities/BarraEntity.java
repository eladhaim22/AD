package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("barra")
public class BarraEntity extends AreaEntity {

    public BarraEntity() {
    }

    public BarraEntity(Integer areaId) {
        super(areaId);
    }
}