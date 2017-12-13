package dto;

import java.io.Serializable;

public class ItemCartaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer itemCartaId;
	private float precio;
	private PlatoDto platoAsociado;
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
