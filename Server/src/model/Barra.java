package model;

import dto.AreaDto;


public class Barra extends Area {

    public Barra(Integer areaId) {
        super(areaId);
    }

    @Override
    public AreaDto toDto() {
        return new AreaDto(this.areaId,"Barra");
    }
}