package entities;

import javax.persistence.*;

@Entity
@Table(name="areas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="nombre", discriminatorType=DiscriminatorType.STRING)
public class AreaEntity {
    private Integer areaId;

    public AreaEntity(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
