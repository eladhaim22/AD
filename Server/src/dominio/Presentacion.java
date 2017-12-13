package dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="presentaciones")
public class Presentacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer presentacionId;
	
	private String nombre;
	
	private float tamanio;

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
