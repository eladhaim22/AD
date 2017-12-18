package entities;


import javax.persistence.*;

@Table(name="itemIngrediente")
@Entity
public class ItemIngredienteEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private IngredienteEntity ingrediente;

    private float cantidad;

    public ItemIngredienteEntity() {
    }

    public ItemIngredienteEntity(Integer id, IngredienteEntity ingrediente, float cantidad) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IngredienteEntity getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteEntity ingrediente) {
        this.ingrediente = ingrediente;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

}
