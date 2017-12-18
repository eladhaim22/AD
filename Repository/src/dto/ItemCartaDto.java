package dto;

import java.io.Serializable;

public class ItemCartaDto implements Serializable{

	public ItemCartaDto(Integer itemCartaId, float precio, PlatoDto platoAsociado, float adicionalComision) {
		this.itemCartaId = itemCartaId;
		this.precio = precio;
		this.platoAsociado = platoAsociado;
		this.adicionalComision = adicionalComision;
	}

	private Integer itemCartaId;
	private float precio;
	private PlatoDto platoAsociado;
	private float adicionalComision;

	public ItemCartaDto() {

	}

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
	public PlatoDto getPlatoAsociado() {
		return platoAsociado;
	}
	public void setPlatoAsociado(PlatoDto platoAsociado) {
		this.platoAsociado = platoAsociado;
	}
	public float getAdicionalComision() {
		return adicionalComision;
	}
	public void setAdicionalComision(float adicionalComision) {
		this.adicionalComision = adicionalComision;
	}
	
	

}
