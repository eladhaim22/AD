package entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="platos")
public class PlatoEntity {

	public PlatoEntity() {
	}

	public PlatoEntity(Integer platoId, String nombre, String unidadMedida, Float porcionesXUnidad, String comentarios, String rubro, Set<ItemIngredienteEntity> ingredientes, AreaEntity area, String receta) {
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer platoId;
	
	private String nombre;
	
	private String unidadMedida;
	
	private Float porcionesXUnidad;
	
	private String comentarios;
	
	private String rubro;

	private String receta;

	@OneToMany (cascade=CascadeType.ALL)
    @JoinColumn(name="platoId")
	private Set<ItemIngredienteEntity> itemsIngredientes = new HashSet<ItemIngredienteEntity>();

	@OneToOne
	private AreaEntity area;

	
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

	public Set<ItemIngredienteEntity> getItemsIngredientes() {
		return itemsIngredientes;
	}

	public void setItemsIngredientes(Set<ItemIngredienteEntity> itemsIngredientes) {
		this.itemsIngredientes = itemsIngredientes;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public Integer getPlatoId() {
		return platoId;
	}

	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}

	public AreaEntity getArea() {
		return area;
	}

	public void setArea(AreaEntity area) {
		this.area = area;
	}

}
