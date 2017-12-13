package dominio;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;

@Entity
@Table (name = "facturas")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroFactura;
	
	private Date fecha;
	
	private float Monto;

	private String medioPago;
	
	private boolean pagado;
	
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
	public Integer getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(Integer numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

}
