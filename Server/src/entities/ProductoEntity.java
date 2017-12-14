package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class ProductoEntity {

	public ProductoEntity(int productoId,String nombre, Boolean comestible, String unidadMedida, Set<PresentacionEntity> presentaciones, Set<IngredienteEntity> ingredientes, Set<MarcaEntity> marcas) {
		this.productoId = productoId;
		this.nombre = nombre;
		this.comestible = comestible;
		this.unidadMedida = unidadMedida;
		this.presentaciones = presentaciones;
		this.ingredientes = ingredientes;
		this.marcas = marcas;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productoId;
	
	@Column (nullable = false, length=100)
	private String nombre;
	
	private Boolean comestible;
	
	private String unidadMedida;
	
	@OneToMany (cascade=CascadeType.ALL) 
    @JoinColumn(name="productoId")
	private Set <PresentacionEntity> presentaciones = new HashSet<PresentacionEntity>();
	
	@OneToMany (cascade=CascadeType.ALL) 
    @JoinColumn(name="semielaboradoId")
	private Set <IngredienteEntity> ingredientes = new HashSet<IngredienteEntity>();
	
	@ManyToMany (cascade=CascadeType.ALL) 
	private Set <MarcaEntity> marcas = new HashSet<MarcaEntity>();
	
	public Set<MarcaEntity> getMarcas() {
		return marcas;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public void setMarcas(Set<MarcaEntity> marcas) {
		this.marcas = marcas;
	}
	
	public void agregarMarca(MarcaEntity newMarca){
		marcas.add(newMarca);
	}

	public ProductoEntity() {
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
	
	public Set<PresentacionEntity> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(Set<PresentacionEntity> presentaciones) {
		this.presentaciones = presentaciones;
	}
	
	public void agregarPresentacion (PresentacionEntity nuevaPresentacion){
		presentaciones.add(nuevaPresentacion);
	}

	public Set<IngredienteEntity> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<IngredienteEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
