package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stocks")
public class StockEntity {

	public StockEntity() {
	}

	public StockEntity(Integer stockId, float cantidadActual, float puntoDeReposicion) {
		this.StockId = stockId;
		this.CantidadActual = cantidadActual;
		this.PuntoDeReposicion = puntoDeReposicion;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer StockId;
	
	@Column
	private float CantidadActual;
	
	@Column
	private float PuntoDeReposicion;

	public Integer getStockId() {
		return StockId;
	}

	public void setStockId(Integer stockId) {
		StockId = stockId;
	}

	public float getCantidadActual() {
		return CantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		CantidadActual = cantidadActual;
	}

	public float getPuntoDeReposicion() {
		return PuntoDeReposicion;
	}

	public void setPuntoDeReposicion(int puntoDeReposicion) {
		PuntoDeReposicion = puntoDeReposicion;
	}

}