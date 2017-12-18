package dto;

import java.io.Serializable;
import java.util.Date;

public class LiquidacionDto implements Serializable{
    private Integer id;
    private MozoDto mozo;
    private Date fecha;
    private Double value;

    public LiquidacionDto(Integer id, MozoDto mozo, Date fecha, Double value) {
        this.id = id;
        this.mozo = mozo;
        this.fecha = fecha;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MozoDto getMozo() {
        return mozo;
    }

    public void setMozo(MozoDto mozo) {
        this.mozo = mozo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
