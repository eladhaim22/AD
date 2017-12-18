package model;

import dto.AreaDto;


public class Cafeteria extends Area {

    public Cafeteria(Integer areaId) {
        super(areaId);
    }

    @Override
    public AreaDto toDto() {
        return new AreaDto(this.areaId,"Cafeteria");
    }
}