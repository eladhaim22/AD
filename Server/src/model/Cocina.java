package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Cocina extends Area {

    public Cocina(Integer areaId) {
        super(areaId);
    }
}
