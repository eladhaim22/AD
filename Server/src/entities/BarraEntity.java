package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("barra")
public class BarraEntity extends AreaEntity {

    public BarraEntity() {
    }

    public BarraEntity(int areaId) {
        super(areaId);
    }
}