package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SectorDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer numeroSector;
	private String nombre;
	private List<MesaDto> mesas = new ArrayList<MesaDto>();
	public Integer getNumeroSector() {
		return numeroSector;
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
	public List<MesaDto> getMesas() {
		return mesas;
	}
	public void setMesas(List<MesaDto> mesas) {
		this.mesas = mesas;
	}

	
}
