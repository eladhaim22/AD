package dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class Producto {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productoId;
	
	@Column (nullable = false, length=100)
	private String nombre;
	
	private Boolean comestible;
	
	private String unidadMedida;
	
	@OneToMany (cascade=CascadeType.ALL) 
    @JoinColumn(name="productoId")
	private Set <Presentacion> presentaciones = new HashSet<Presentacion>();
	
	@OneToMany (cascade=CascadeType.ALL) 
    @JoinColumn(name="semielaboradoId")
	private Set <Ingrediente> ingredientes = new HashSet<Ingrediente>();
	
	@ManyToMany (cascade=CascadeType.ALL) 
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
