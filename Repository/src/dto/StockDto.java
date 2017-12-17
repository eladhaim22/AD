package dto;

import java.io.Serializable;

public class StockDto implements Serializable{
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
