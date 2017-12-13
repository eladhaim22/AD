package dto;

import java.io.Serializable;
import java.util.Date;

public class CartaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cartaId;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFinal;
	
	
	public Integer getCartaId() {
		return cartaId;
	}
	public void setCartaId(Integer cartaId) {
		this.cartaId = cartaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
