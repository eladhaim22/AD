package entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="sucursales")
public class SucursalEntity{

	public SucursalEntity() {
	}

	public SucursalEntity(Integer sucursalId, String nombre, String direccion, String telefono, String email, Integer capacidadMaxima, List<SectorEntity> sectores, List<CartaEntity> cartas) {
		this.sucursalId = sucursalId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.capacidadMaxima = capacidadMaxima;
		this.sectores = sectores;
		this.cartas = cartas;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sucursalId;
	
	@Column
	private String nombre;
	
	@Column(nullable = false, length=100)
	private String direccion;
	
	@Column(nullable = false, length=30)
	private String telefono;
	
	@Column
	private String email;

	@Column(name="CapacidadMaxima")
	private Integer capacidadMaxima;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="sucursalId")
	private List<SectorEntity> sectores = new ArrayList<SectorEntity>();
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="sucursalId")
	private List<CartaEntity> cartas = new ArrayList<CartaEntity>();


	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
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

	public List<SectorEntity> getSectores() {
		return sectores;
	}

	public void setSectores(List<SectorEntity> sectores) {
		this.sectores = sectores;
	}
	
	public void AgregarSector(SectorEntity newSector){
		sectores.add(newSector);
	}
	
	public SectorEntity buscarSector(Integer numeroSector){
		for(SectorEntity s : sectores){
			if(s.getNumeroSector().equals(numeroSector))return s;
		}
		return null;
	}

	public void AgregarCarta(CartaEntity nuevaCarta) {
		this.cartas.add(nuevaCarta);
	}


	public Integer getSucursalId() {
		return sucursalId;
	}


	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}


	public List<CartaEntity> getCartas() {
		return cartas;
	}


	public void setCartas(List<CartaEntity> cartas) {
		this.cartas = cartas;
	}
	
}
