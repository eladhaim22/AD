package dto;

import java.io.Serializable;

public class IngredienteDto implements Serializable{

    public IngredienteDto(Integer ingredienteId, String nombre, String unidadDeMedida) {
        this.ingredienteId = ingredienteId;
        this.nombre = nombre;
        this.unidadDeMedida = unidadDeMedida;
    }

    private Integer ingredienteId;

    private String nombre;

    private String unidadDeMedida;

    public Integer getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Integer ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
