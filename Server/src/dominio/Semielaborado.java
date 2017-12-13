package dominio;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="semielaborados")
public class Semielaborado {

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
