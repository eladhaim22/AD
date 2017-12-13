package dominio;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="sucursales")
public class Sucursal implements Serializable{

	private static final long serialVersionUID = 1L;

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
	private List<Sector> sectores = new ArrayList<Sector>();
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="sucursalId")
	private List<Carta> cartas = new ArrayList<Carta>();
	
	
	public Sucursal() {
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

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
	
	public void AgregarSector(Sector newSector){
		sectores.add(newSector);
	}
	
	public Sector buscarSector(Integer numeroSector){
		for(Sector s : sectores){
			if(s.getNumeroSector().equals(numeroSector))return s;
		}
		return null;
	}

	public void AgregarCarta(Carta nuevaCarta) {
		this.cartas.add(nuevaCarta);
	}


	public Integer getSucursalId() {
		return sucursalId;
	}


	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}


	public List<Carta> getCartas() {
		return cartas;
	}


	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
}
