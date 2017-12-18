package model;


public class Stock {
	public Stock(Integer stockId, float cantidadActual, float puntoDeReposicion) {
		StockId = stockId;
		CantidadActual = cantidadActual;
		PuntoDeReposicion = puntoDeReposicion;
	}

	private Integer StockId;
	private float CantidadActual;
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

	public void setCantidadActual(float cantidadActual) {
		CantidadActual = cantidadActual;
	}

	public float getPuntoDeReposicion() {
		return PuntoDeReposicion;
	}

	public void setPuntoDeReposicion(float puntoDeReposicion) {
		PuntoDeReposicion = puntoDeReposicion;
	}
	
	public void reponerStock(){
		this.CantidadActual = this.CantidadActual+this.PuntoDeReposicion;
	}

}