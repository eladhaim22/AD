package dominio;

import javax.persistence.*;

@Entity
//@MappedSuperclass
@Table(name="ingredientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="tipo", discriminatorType=DiscriminatorType.STRING)
public abstract class Ingrediente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ingredienteId;
	
	private float cantidad;

	public Integer getIngredienteId() {
		return ingredienteId;
	}
	
	@OneToOne
	private Stock stock;

	public void setIngredienteId(Integer ingredienteId) {
		this.ingredienteId = ingredienteId;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	

}
