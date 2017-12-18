package model;

import daos.PlatoDao;
import dto.PlatoDto;


import java.util.HashSet;
import java.util.Set;

public class Plato {
	public Plato(Integer platoId, String nombre, String unidadMedida, Float porcionesXUnidad, String comentarios, String rubro, Set<ItemIngrediente> ingredientes, Area area,String receta) {
		this.platoId = platoId;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.porcionesXUnidad = porcionesXUnidad;
		this.comentarios = comentarios;
		this.rubro = rubro;
		this.itemsIngredientes = ingredientes;
		this.area = area;
		this.receta = receta;
	}
	private Integer platoId;
	private String nombre;
	private String unidadMedida;
	private Float porcionesXUnidad;
	private String comentarios;
	private String rubro;
	private Set<ItemIngrediente> itemsIngredientes = new HashSet<ItemIngrediente>();
	private Area area;
	private String receta;

	public Set<ItemIngrediente> getItemsIngredientes() {
		return itemsIngredientes;
	}

	public void setItemsIngredientes(Set<ItemIngrediente> itemsIngredientes) {
		this.itemsIngredientes = itemsIngredientes;
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

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
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

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
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
		PlatoDto.setReceta(this.getReceta());
		PlatoDto.setAreaId(this.getArea().getAreaId());
		return PlatoDto;
	}

    public void descontarStock(float cantidad) {
		this.itemsIngredientes.stream().
				forEach(itemIngrediente -> itemIngrediente.getIngrediente()
						.descontar(cantidad * itemIngrediente.getCantidad()));
    }
}
