package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemsRemitos")
public class ItemRemitoEntity {

	public ItemRemitoEntity() {
	}

	public ItemRemitoEntity(Integer cantidad, IngredienteEntity ingrediente) {
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemRemitoId;
	
	@Column
	private int cantidad;
	
	@OneToOne
	private IngredienteEntity ingrediente;


	public Integer getItemRemitoId() {
		return itemRemitoId;
	}


	public void setItemRemitoId(Integer itemRemitoId) {
		this.itemRemitoId = itemRemitoId;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public IngredienteEntity getIngrediente() {
		return ingrediente;
	}


	public void setIngrediente(IngredienteEntity ingrediente) {
		this.ingrediente = ingrediente;
	}

}
