package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemsRemitos")
public class ItemRemito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemRemitoId;
	
	@Column
	private int cantidad;
	
	@OneToOne
	private Ingrediente ingrediente;


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


	public Ingrediente getIngrediente() {
		return ingrediente;
	}


	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

}
