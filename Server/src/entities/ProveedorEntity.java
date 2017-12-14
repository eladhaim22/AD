package entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table (name ="proveedores")
public class ProveedorEntity {

	public ProveedorEntity(String nombre, String direccion, String telefono, String email, String CUIL, String nombreContacto, Set<ProductoEntity> productos) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.CUIL = CUIL;
		this.nombreContacto = nombreContacto;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer proveedorId;
	
	@Column(nullable = false, length=50)
	private String nombre;
	@Column(nullable = false, length=70)
	private String direccion;
	@Column(nullable = false, length=30)
	private String telefono;
	@Column(length=50)
	private String email;
	@Column(nullable = false, length=20)
	private String CUIL;
	@Column(length=70)
	private String nombreContacto;
	
	@ManyToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="proveedorId")
	private Set<ProductoEntity> productos = new HashSet<ProductoEntity>();
	
	
	public Set<ProductoEntity> getProductos() {
		return productos;
	}
	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCUIL() {
		return CUIL;
	}
	public void setCUIL(String cUIL) {
		CUIL = cUIL;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	
	public void agregarProducto(ProductoEntity newProducto){
		productos.add(newProducto);
	}
	public Integer getProveedorId() {
		return proveedorId;
	}
	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}
}
