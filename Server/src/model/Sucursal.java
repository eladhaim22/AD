package model;

import daos.SucursalDao;
import dto.SucursalDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Sucursal {
	public Sucursal(Integer sucursalId, String nombre, String direccion, String telefono, String email, Integer capacidadMaxima, List<Sector> sectores, List<Carta> cartas) {
		this.sucursalId = sucursalId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.capacidadMaxima = capacidadMaxima;
		this.sectores = sectores;
		this.cartas = cartas;
	}

	private Integer sucursalId;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private Integer capacidadMaxima;
	private List<Sector> sectores = new ArrayList<Sector>();
	private List<Carta> cartas = new ArrayList<Carta>();


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

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
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

	public void save(){
		SucursalDao.getDao().save(this);
	}

	public SucursalDto toDto(){
		SucursalDto SucursalDto = new SucursalDto();
		SucursalDto.setCartas(this.getCartas().stream().map(carta -> carta.toDto()).collect(Collectors.toList()));
		SucursalDto.setDireccion(this.getDireccion());
		SucursalDto.setNombre(this.getNombre());
		SucursalDto.setEmail(this.getEmail());
		SucursalDto.setTelefono(this.getTelefono());
		SucursalDto.setSucursalId(this.getSucursalId());
		SucursalDto.setSectores(this.getSectores().stream().map(sector -> sector.toDto()).collect(Collectors.toList()));
		return SucursalDto;
	}
}
