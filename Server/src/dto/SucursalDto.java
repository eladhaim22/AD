package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SucursalDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer sucursalId;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private List <SectorDto> sectores = new ArrayList<SectorDto>();
	private List<CartaDto> cartas= new ArrayList<CartaDto>();

	
	
	public Integer getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
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
	public List<SectorDto> getSectores() {
		return sectores;
	}
	public void setSectores(List<SectorDto> sectores) {
		this.sectores = sectores;
	}
	public List<CartaDto> getCartas() {
		return cartas;
	}
	public void setCartas(List<CartaDto> cartas) {
		this.cartas = cartas;
	}

}
