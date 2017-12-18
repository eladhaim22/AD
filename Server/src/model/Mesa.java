package model;

import daos.MesaDao;
import dto.MesaDto;

import javax.persistence.*;
import java.io.Serializable;

public class 	Mesa{
	public Mesa(Integer mesaId, Integer numeroMesa, Integer capacidad, boolean isEmpty, boolean estaPago) {
		this.mesaId = mesaId;
		this.numeroMesa = numeroMesa;
		this.capacidad = capacidad;
		this.isEmpty = isEmpty;
		this.estaPago = estaPago;
	}

	private Integer mesaId;
	private Integer numeroMesa;
	private Integer capacidad;
	private boolean isEmpty;
	private boolean estaPago;

	public Integer getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Integer getMesaId() {
		return mesaId;
	}

	public void setMesaId(Integer mesaId) {
		this.mesaId = mesaId;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public boolean isEstaPago() {
		return estaPago;
	}

	public void setEstaPago(boolean estaPago) {
		this.estaPago = estaPago;
	}

	public void save(){
		MesaDao.getDao().save(this);
	}

	public void update(){
		MesaDao.getDao().update(this);
	}

	public MesaDto toDto(){
		MesaDto mesaDto = new MesaDto();
		mesaDto.setId(this.getMesaId());
		mesaDto.setCapacidad(this.getCapacidad());
		mesaDto.setEmpty(this.isEmpty());
		mesaDto.setNumero(this.getNumeroMesa());
		mesaDto.setEmpty(this.isEstaPago());
		return mesaDto;
	}

    public void cerrarMesa() {
		this.isEmpty = true;
		this.estaPago = true;
		this.update();
    }
}
