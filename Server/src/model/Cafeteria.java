package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Cafeteria extends Area {

    public Cafeteria(Integer areaId) {
        super(areaId);
    }
}