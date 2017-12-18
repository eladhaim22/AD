package dto;

import java.io.Serializable;

public class ItemIngredienteDTO implements Serializable{
    private Integer id;
    private float cantidad;
    private Integer ingrediente;

    public ItemIngredienteDTO(Integer id, float cantidad, Integer ingrediente) {
        this.id = id;
        this.cantidad = cantidad;
        this.ingrediente = ingrediente;
    }

    public Integer getId() {
        return id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public Integer getIngrediente() {
        return ingrediente;
    }
}
