package model;

import dto.AreaDto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Cocina extends Area {

    public Cocina(Integer areaId) {
        super(areaId);
    }

    @Override
    public AreaDto toDto() {
        return new AreaDto(this.areaId,"Cocina");
    }
}
