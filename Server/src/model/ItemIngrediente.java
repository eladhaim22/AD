package model;

public class ItemIngrediente {
    private Integer id;
    private Ingrediente ingrediente;
    private float cantidad;

    public ItemIngrediente(int id, Ingrediente ingrediente, float cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}
