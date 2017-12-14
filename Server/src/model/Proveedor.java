package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Proveedor {
	public Proveedor(Integer proveedorId, String nombre, String direccion, String telefono, String email, String CUIL, String nombreContacto, Set<Producto> productos) {
		this.proveedorId = proveedorId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.CUIL = CUIL;
		this.nombreContacto = nombreContacto;
		this.productos = productos;
	}

	private Integer proveedorId;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String CUIL;
	private String nombreContacto;
	private Set<Producto> productos = new HashSet<Producto>();
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Set<Producto> productos) {
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
	
	public void agregarProducto(Producto newProducto){
		productos.add(newProducto);
	}
	public Integer getProveedorId() {
		return proveedorId;
	}
	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}
}
