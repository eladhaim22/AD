package model;

import daos.PedidoDao;
import daos.PlatoDao;
import dto.PlatoDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Plato {
	public Plato(Integer platoId, String nombre, String unidadMedida, Float porcionesXUnidad, String comentarios, String rubro, Set<Ingrediente> ingredientes, Area area) {
		this.platoId = platoId;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.porcionesXUnidad = porcionesXUnidad;
		this.comentarios = comentarios;
		this.rubro = rubro;
		this.ingredientes = ingredientes;
		this.area = area;
	}
	private Integer platoId;
	private String nombre;
	private String unidadMedida;
	private Float porcionesXUnidad;
	private String comentarios;
	private String rubro;
	private Set<Ingrediente> ingredientes = new HashSet<Ingrediente>();
	private Area area;

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

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void setNuevoIngrediente(Ingrediente newIngrediente){
		ingredientes.add(newIngrediente);
	}

	public Integer getPlatoId() {
		return platoId;
	}

	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void save(){
		PlatoDao.getDao().save(this);
	}

	public PlatoDto toDto(){
		PlatoDto PlatoDto = new PlatoDto();
		PlatoDto.setPlatoId(this.getPlatoId());
		PlatoDto.setNombre(this.getNombre());
		PlatoDto.setUnidadMedida(this.getUnidadMedida());
		PlatoDto.setPorcionesXUnidad(this.getPorcionesXUnidad());
		PlatoDto.setComentarios(this.getComentarios());
		return PlatoDto;
	}
}
