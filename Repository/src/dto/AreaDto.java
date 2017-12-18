package dto;

import java.io.Serializable;

public class AreaDto implements Serializable{
    private Integer areaId;
    private String nombre;

    public AreaDto(Integer areaId, String nombre) {
        this.areaId = areaId;
        this.nombre = nombre;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
