package dominio;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="platos")
public class Plato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer platoId;
	
	private String nombre;
	
	private String unidadMedida;
	
	private Float porcionesXUnidad;
	
	private String comentarios;
	
	private String rubro;
	
	@OneToMany (cascade=CascadeType.ALL)
    @JoinColumn(name="platoId")
	private Set <Ingrediente> ingredientes = new HashSet<Ingrediente>();

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

}
