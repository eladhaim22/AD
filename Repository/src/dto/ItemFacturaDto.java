package dto;

import java.io.Serializable;

public class ItemFacturaDto implements Serializable {

    public ItemFacturaDto() {
    }

    public ItemFacturaDto(Integer id, String nombrePlato, float cantidad, float precio) {
        this.id = id;
        this.nombrePlato = nombrePlato;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    private Integer id;
    private String nombrePlato;
    private float cantidad;
    private float precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
