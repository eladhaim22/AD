package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="mesas")
public class MesaEntity{

	public MesaEntity(int mesaId,Integer numeroMesa, Integer capacidad, boolean isEmpty, boolean estaPago) {
		this.mesaId = mesaId;
		this.numeroMesa = numeroMesa;
		this.capacidad = capacidad;
		this.isEmpty = isEmpty;
		this.estaPago = estaPago;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer mesaId;
	
	@Column(nullable = false)
	private Integer numeroMesa;
	
	@Column
	private Integer capacidad;
	
	@Column(name = "empty")
	private boolean isEmpty;
	
	@Column(name = "pago")
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

}
