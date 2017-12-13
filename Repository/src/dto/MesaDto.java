package dto;

import java.io.Serializable;

public class MesaDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer numero;
	private int capacidad;
	private boolean isEmpty;
	private boolean estaPaga;
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero() {
		return numero;
	}
	
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public boolean isEstaPaga() {
		return estaPaga;
	}
	public void setEstaPaga(boolean estaPaga) {
		this.estaPaga = estaPaga;
	}	
}