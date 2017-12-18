package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="presentaciones")
public class PresentacionEntity{

	public PresentacionEntity() {
	}

	public PresentacionEntity(Integer presentacionId, String nombre, float tamanio) {
		this.presentacionId = presentacionId;
		this.nombre = nombre;
		this.tamanio = tamanio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
