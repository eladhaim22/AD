package entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cafeteria")
public class CafeteriaEntity extends AreaEntity {


    public CafeteriaEntity() {
    }

    public CafeteriaEntity(Integer areaId) {
        super(areaId);
    }
}