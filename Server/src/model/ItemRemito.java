package model;

import javax.persistence.*;

public class ItemRemito {
	public ItemRemito(Integer itemRemitoId, int cantidad, Ingrediente ingrediente) {
		this.itemRemitoId = itemRemitoId;
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
	}

	private Integer itemRemitoId;
	private int cantidad;
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
