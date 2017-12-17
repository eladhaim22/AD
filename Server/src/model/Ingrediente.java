package model;

public class Ingrediente {

	public Ingrediente(Integer ingredienteId, String nombre, Stock stock,String unidadDeMedida) {
		this.ingredienteId = ingredienteId;
		this.nombre = nombre;
		this.stock = stock;
		this.unidadDeMedida = unidadDeMedida;
	}

	private Integer ingredienteId;
	
	private String nombre;

	public Integer getIngredienteId() {
		return ingredienteId;
	}
	
	private Stock stock;

	private String unidadDeMedida;

	public void setIngredienteId(Integer ingredienteId) {
		this.ingredienteId = ingredienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(float cantidad) {
		this.nombre = nombre;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}
}
