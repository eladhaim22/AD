package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Factura {

	public Factura(Integer numeroFactura, Date fecha, float monto, String medioPago, boolean pagado, 		Set<ItemFactura> itemsFactura) {
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		Monto = monto;
		this.medioPago = medioPago;
		this.pagado = pagado;
		this.itemsFactura = itemsFactura;
	}

	private Integer numeroFactura;
	
	private Date fecha;
	
	private float Monto;

	private String medioPago;
	
	private boolean pagado;
	
	private Set<ItemFactura> itemsFactura = new HashSet<>();
	
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
	public Set<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(Set<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}

	
}
