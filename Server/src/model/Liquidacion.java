package model;

import java.util.Date;

public class Liquidacion {

	public Liquidacion(Integer id, Mozo usuario, Date fecha, Double value) {
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.value = value;
	}

	private Integer id;
	private Mozo usuario;
	private Date fecha;
	private Double value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mozo getUsuario() {
		return usuario;
	}

	public void setUsuario(Mozo usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
