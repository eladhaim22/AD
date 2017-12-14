package model;

import daos.SucursalDao;

import javax.persistence.*;

public class Stock {
	public Stock(Integer stockId, int cantidadActual, int puntoDeReposicion) {
		StockId = stockId;
		CantidadActual = cantidadActual;
		PuntoDeReposicion = puntoDeReposicion;
	}

	private Integer StockId;
	private int CantidadActual;
	private int PuntoDeReposicion;

	public Integer getStockId() {
		return StockId;
	}

	public void setStockId(Integer stockId) {
		StockId = stockId;
	}

	public int getCantidadActual() {
		return CantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		CantidadActual = cantidadActual;
	}

	public int getPuntoDeReposicion() {
		return PuntoDeReposicion;
	}

	public void setPuntoDeReposicion(int puntoDeReposicion) {
		PuntoDeReposicion = puntoDeReposicion;
	}

}