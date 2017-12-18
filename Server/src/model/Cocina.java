package model;

import dto.AreaDto;


public class Cocina extends Area {

    public Cocina(Integer areaId) {
        super(areaId);
    }

    @Override
    public AreaDto toDto() {
        return new AreaDto(this.areaId,"Cocina");
    }
}
