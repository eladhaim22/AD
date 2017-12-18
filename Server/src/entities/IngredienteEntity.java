package entities;

import javax.persistence.*;

@Entity
@Table(name="ingredientes")
public class IngredienteEntity {

	public IngredienteEntity() {
	}

	public IngredienteEntity(Integer ingredienteId, String nombre, StockEntity stock, String unidadDeMedida) {
		this.ingredienteId = ingredienteId;
		this.nombre = nombre;
		this.stock = stock;
		this.unidadDeMedida = unidadDeMedida;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ingredienteId;
	
	private String nombre;


	@OneToOne
	private StockEntity stock;

	private String unidadDeMedida;

	public Integer getIngredienteId() {
		return ingredienteId;
	}

	public void setIngredienteId(Integer ingredienteId) {
		this.ingredienteId = ingredienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
		this.stock = stock;
	}

	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}
}
