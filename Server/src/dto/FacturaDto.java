package dto;

import java.io.Serializable;
import java.util.Date;

public class FacturaDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numeroFactura;
	
	private Date fecha;
	
	private float Monto;

	private String medioPago;
	
	private boolean pagado;

	public Integer getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Integer numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return Monto;
	}

	public void setMonto(float monto) {
		Monto = monto;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

}
