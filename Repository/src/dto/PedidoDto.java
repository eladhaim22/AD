package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer numeroPedido;

	private Integer mozoId;
	
	private Integer cantComensales;
	
	private Date FechaApertura;

	private Date FechaCierre;

	private Integer mesaId;

	private List<ComandaDto> comandas = new ArrayList<>();

	private FacturaDto factura;

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Integer getMozoId() {
		return mozoId;
	}

	public void setMozoId(Integer mozoId) {
		this.mozoId = mozoId;
	}

	public Integer getCantComensales() {
		return cantComensales;
	}

	public void setCantComensales(Integer cantComensales) {
		this.cantComensales = cantComensales;
	}

	public Date getFechaApertura() {
		return FechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		FechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return FechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		FechaCierre = fechaCierre;
	}

	public Integer getMesaId() {
		return mesaId;
	}

	public void setMesaId(Integer mesaId) {
		this.mesaId = mesaId;
	}

	public List<ComandaDto> getComandas() {
		return comandas;
	}

	public void setComandas(List<ComandaDto> comandas) {
		this.comandas = comandas;
	}

	public FacturaDto getFactura() {
		return factura;
	}

	public void setFactura(FacturaDto factura) {
		this.factura = factura;
	}
}
