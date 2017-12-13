package dto;

import java.io.Serializable;

public class PlatoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer platoId;
	private String nombre;
	private String unidadMedida;
	private Float porcionesXUnidad;
	private String comentarios;
	public Integer getPlatoId() {
		return platoId;
	}
	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}
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
	public Float getPorcionesXUnidad() {
		return porcionesXUnidad;
	}
	public void setPorcionesXUnidad(Float porcionesXUnidad) {
		this.porcionesXUnidad = porcionesXUnidad;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	
}
