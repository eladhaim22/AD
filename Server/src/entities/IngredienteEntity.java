package entities;

import javax.persistence.*;

@Entity
@Table(name="ingredientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="tipo", discriminatorType=DiscriminatorType.STRING)
public abstract class IngredienteEntity {

	public IngredienteEntity(int ingredienteId,float cantidad, StockEntity stock) {
		this.ingredienteId = ingredienteId;
		this.cantidad = cantidad;
		this.stock = stock;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ingredienteId;
	
	private float cantidad;

	public Integer getIngredienteId() {
		return ingredienteId;
	}
	
	@OneToOne
	private StockEntity stock;

	public void setIngredienteId(Integer ingredienteId) {
		this.ingredienteId = ingredienteId;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
		this.stock = stock;
	}
	
	

}
