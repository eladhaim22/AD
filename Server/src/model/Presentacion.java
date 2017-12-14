package model;

import javax.persistence.*;
import java.io.Serializable;

public class Presentacion{

	public Presentacion(Integer presentacionId, String nombre, float tamanio) {
		this.presentacionId = presentacionId;
		this.nombre = nombre;
		this.tamanio = tamanio;
	}

	private Integer presentacionId;
	
	private String nombre;
	
	private float tamanio;

	public Integer getPresentacionId() {
		return presentacionId;
	}

	public void setPresentacionId(Integer presentacionId) {
		this.presentacionId = presentacionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTamanio() {
		return tamanio;
	}

	public void setTamanio(float tamanio) {
		this.tamanio = tamanio;
	}

}
