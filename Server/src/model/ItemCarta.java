package model;

public class ItemCarta {

	public ItemCarta(Integer itemCartaId, float precio, Plato platoAsociado, float adicionalComision) {
		this.itemCartaId = itemCartaId;
		this.precio = precio;
		this.platoAsociado = platoAsociado;
		this.adicionalComision = adicionalComision;
	}

	private Integer itemCartaId;
	
	private float precio;
	
	private Plato platoAsociado;
	
	private float adicionalComision;


	public Integer getItemCartaId() {
		return itemCartaId;
	}

	public void setItemCartaId(Integer itemCartaId) {
		this.itemCartaId = itemCartaId;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Plato getPlatoAsociado() {
		return platoAsociado;
	}

	public void setPlatoAsociado(Plato platoAsociado) {
		this.platoAsociado = platoAsociado;
	}

	public float getAdicionalComision() {
		return adicionalComision;
	}

	public void setAdicionalComision(float adicionalComision) {
		this.adicionalComision = adicionalComision;
	}

}
