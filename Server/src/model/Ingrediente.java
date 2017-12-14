package model;

public abstract class Ingrediente {

	public Ingrediente(Integer ingredienteId, float cantidad, Stock stock) {
		this.ingredienteId = ingredienteId;
		this.cantidad = cantidad;
		this.stock = stock;
	}

	private Integer ingredienteId;
	
	private float cantidad;

	public Integer getIngredienteId() {
		return ingredienteId;
	}
	
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
