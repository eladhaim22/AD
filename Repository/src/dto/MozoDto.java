package dto;

import java.io.Serializable;

public class MozoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private float porcComision;
	private String tipo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPorcComision() {
		return porcComision;
	}
	public void setPorcComision(float porcComision) {
		this.porcComision = porcComision;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
