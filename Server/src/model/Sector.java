package model;

import dto.SectorDto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Sector {
	public Sector(Integer numeroSector, String nombre, Set<Mesa> mesas, Integer cantMesas, Mozo mozoAsociado) {
		this.numeroSector = numeroSector;
		this.nombre = nombre;
		this.mesas = mesas;
		this.cantMesas = cantMesas;
		this.mozoAsociado = mozoAsociado;
	}

	private Integer numeroSector;
	private String nombre;
	private Set <Mesa> mesas = new HashSet<Mesa>();
	private Integer cantMesas;
	private Mozo mozoAsociado;

	public Integer getNumeroSector() {
		return numeroSector;
	}

	public Mozo getMozoAsociado() {
		return mozoAsociado;
	}

	public void setMozoAsociado(Mozo mozoAsociado) {
		this.mozoAsociado = mozoAsociado;
	}

	public void setNumeroSector(Integer numeroSector) {
		this.numeroSector = numeroSector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Integer getCantMesas() {
		return cantMesas;
	}

	public void setCantMesas(Integer cantMesas) {
		this.cantMesas = cantMesas;
	}

	public SectorDto toDto(){
		SectorDto SectorDto = new SectorDto();
		SectorDto.setNumeroSector(this.getNumeroSector());
		SectorDto.setNombre(this.getNombre());
		SectorDto.setMesas(this.getMesas().stream().map(mesa -> mesa.toDto()).collect(Collectors.toList()	));
		return SectorDto;
	}
}
