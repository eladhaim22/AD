package dto;

import java.io.Serializable;

public class SemiElaboradoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String unidadMedida;
	private float tiempoDeElaboracion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public float getTiempoDeElaboracion() {
		return tiempoDeElaboracion;
	}
	public void setTiempoDeElaboracion(float tiempoDeElaboracion) {
		this.tiempoDeElaboracion = tiempoDeElaboracion;
	}
	
}
