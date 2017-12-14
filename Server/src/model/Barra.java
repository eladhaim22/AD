package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Barra extends Area {

    public Barra(Integer areaId) {
        super(areaId);
    }
}