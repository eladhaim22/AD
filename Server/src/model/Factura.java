package model;

import dto.FacturaDto;

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
	
	private double Monto;

	private String medioPago;
	
	private boolean pagado;
	
	private Set<ItemFactura> itemsFactura = new HashSet<>();

	public Factura() {

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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
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

	public FacturaDto ToDto(){
		FacturaDto FacturaDto = new FacturaDto();
		FacturaDto.setNumeroFactura(this.getNumeroFactura());
		FacturaDto.setFecha(this.getFecha());
		FacturaDto.setMedioPago(this.getMedioPago());
		FacturaDto.setMonto(this.getMonto());
		FacturaDto.setPagado(this.isPagado());
		return FacturaDto;
	}

	public void calcularFactura() {
		this.Monto = this.itemsFactura.stream().mapToDouble(itemFactura ->
				itemFactura.getPrecio() * itemFactura.getCantidad()).sum();
	}
}
