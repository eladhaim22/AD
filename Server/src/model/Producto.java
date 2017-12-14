package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Producto {
	public Producto(Integer productoId, String nombre, Boolean comestible, String unidadMedida, Set<Presentacion> presentaciones, Set<Ingrediente> ingredientes, Set<Marca> marcas) {
		this.productoId = productoId;
		this.nombre = nombre;
		this.comestible = comestible;
		this.unidadMedida = unidadMedida;
		this.presentaciones = presentaciones;
		this.ingredientes = ingredientes;
		this.marcas = marcas;
	}

	private Integer productoId;
	private String nombre;
	private Boolean comestible;
	private String unidadMedida;
	private Set <Presentacion> presentaciones = new HashSet<Presentacion>();
	private Set <Ingrediente> ingredientes = new HashSet<Ingrediente>();
	private Set <Marca> marcas = new HashSet<Marca>();

	public Set<Marca> getMarcas() {
		return marcas;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public void setMarcas(Set<Marca> marcas) {
		this.marcas = marcas;
	}

	public void agregarMarca(Marca newMarca){
		marcas.add(newMarca);
	}

	public Producto() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getComestible() {
		return comestible;
	}
	public void setComestible(Boolean comestible) {
		this.comestible = comestible;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Set<Presentacion> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(Set<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}

	public void agregarPresentacion (Presentacion nuevaPresentacion){
		presentaciones.add(nuevaPresentacion);
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
