package entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="semielaborados")
public class SemielaboradoEntity {

	public SemielaboradoEntity(Integer seminelabodadoId, String nombre, String unidadMedida, float porcionesXUnidad, float tiempoElaboracionXUnidad, Set<IngredienteEntity> ingredientes) {
		this.seminelabodadoId = seminelabodadoId;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.porcionesXUnidad = porcionesXUnidad;
		this.tiempoElaboracionXUnidad = tiempoElaboracionXUnidad;
		this.ingredientes = ingredientes;
	}

	@Id
	private Integer seminelabodadoId;
	
	private String nombre;
	
	@Column(nullable = false)
	private String unidadMedida;
	
	@Column(nullable = false)
	private float porcionesXUnidad;
	
	@Column(nullable = false)
	private float tiempoElaboracionXUnidad;
	
	@OneToMany (cascade=CascadeType.ALL) // se pone EAGER para que cuando cargo el objeto traiga todos los objetos relacionados de la base de datos.
    @JoinColumn(name="semielaboradoId")
	private Set <IngredienteEntity> ingredientes = new HashSet<IngredienteEntity>();

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

	public Set<IngredienteEntity> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<IngredienteEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void AgregarIngrediente(IngredienteEntity newIngrediente){
		ingredientes.add(newIngrediente);
	}

}
