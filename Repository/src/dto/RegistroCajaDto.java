package dto;

import java.io.Serializable;
import java.util.Date;

public class RegistroCajaDto implements Serializable {
    private Integer id;
    private Integer sucursalId;
    private Date date;
    private double valorCaja;
    private double valorEsperado;

    public RegistroCajaDto(Integer id, Integer sucursalId, Date date, double valorCaja, double valorEsperado) {
        this.id = id;
        this.sucursalId = sucursalId;
        this.date = date;
        this.valorCaja = valorCaja;
        this.valorEsperado = valorEsperado;
    }

    public double getValorCaja() {
        return valorCaja;
    }

    public double getValorEsperado() {
        return valorEsperado;
    }
}
