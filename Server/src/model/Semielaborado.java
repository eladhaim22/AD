package model;


import java.util.HashSet;
import java.util.Set;

public class Semielaborado {
	public Semielaborado(Integer seminelabodadoId, String nombre, String unidadMedida, float porcionesXUnidad, float tiempoElaboracionXUnidad, Set<Ingrediente> ingredientes) {
		this.seminelabodadoId = seminelabodadoId;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.porcionesXUnidad = porcionesXUnidad;
		this.tiempoElaboracionXUnidad = tiempoElaboracionXUnidad;
		this.ingredientes = ingredientes;
	}



	private Integer seminelabodadoId;
	private String nombre;
	private String unidadMedida;
	private float porcionesXUnidad;
	private float tiempoElaboracionXUnidad;
	private Set <Ingrediente> ingredientes = new HashSet<Ingrediente>();

	public Integer getSeminelabodadoId() {
		return seminelabodadoId;
	}

	public void setSeminelabodadoId(Integer seminelabodadoId) {
		this.seminelabodadoId = seminelabodadoId;
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

	public float getPorcionesXUnidad() {
		return porcionesXUnidad;
	}

	public void setPorcionesXUnidad(float porcionesXUnidad) {
		this.porcionesXUnidad = porcionesXUnidad;
	}

	public float getTiempoElaboracionXUnidad() {
		return tiempoElaboracionXUnidad;
	}

	public void setTiempoElaboracionXUnidad(float tiempoElaboracionXUnidad) {
		this.tiempoElaboracionXUnidad = tiempoElaboracionXUnidad;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void AgregarIngrediente(Ingrediente newIngrediente){
		ingredientes.add(newIngrediente);
	}

}
