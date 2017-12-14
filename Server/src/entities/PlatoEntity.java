package entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="platos")
public class PlatoEntity {

	public PlatoEntity(int platoId,String nombre, String unidadMedida, Float porcionesXUnidad, String comentarios, String rubro, Set<IngredienteEntity> ingredientes, IngredientEntity area) {
		this.platoId = platoId;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.porcionesXUnidad = porcionesXUnidad;
		this.comentarios = comentarios;
		this.rubro = rubro;
		this.ingredientes = ingredientes;
		this.area = area;
	}

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
	private Set<IngredienteEntity> ingredientes = new HashSet<IngredienteEntity>();

	@OneToOne
	private IngredientEntity area;

	
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

	public Set<IngredienteEntity> getIngredientes() {
		return ingredientes;
	}
	
	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public void setIngredientes(Set<IngredienteEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void setNuevoIngrediente(IngredienteEntity newIngrediente){
		ingredientes.add(newIngrediente);
	}

	public Integer getPlatoId() {
		return platoId;
	}

	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}

	public IngredientEntity getArea() {
		return area;
	}

	public void setArea(IngredientEntity area) {
		this.area = area;
	}
	
	

}
