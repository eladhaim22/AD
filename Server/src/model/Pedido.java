package model;

import daos.PedidoDao;
import dto.PedidoDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
	public Pedido(Integer numeroPedido, Integer cantComensales, Factura factura, Mozo mozo, Date fechaApertura, Date fechaCierre, Set<Comanda> comandas, Mesa mesaAsociada,Sucursal sucursal) {
		this.numeroPedido = numeroPedido;
		this.cantComensales = cantComensales;
		this.factura = factura;
		this.mozo = mozo;
		FechaApertura = fechaApertura;
		FechaCierre = fechaCierre;
		this.comandas = comandas;
		this.mesaAsociada = mesaAsociada;
		this.sucursal = sucursal;
	}

	private Integer numeroPedido;
	private Integer cantComensales;
	private Factura factura;
	private Mozo mozo;
	private Date FechaApertura;
	private Date FechaCierre;
	private Set<Comanda> comandas = new HashSet<Comanda>();
	private Mesa mesaAsociada;
	private Sucursal sucursal;

    public Pedido() {

    }

    public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Integer getCantComensales() {
		return cantComensales;
	}

	public void setCantComensales(Integer cantComensales) {
		this.cantComensales = cantComensales;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
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

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}

	public Mesa getMesaAsociada() {
		return mesaAsociada;
	}

	public void setMesaAsociada(Mesa mesaAsociada) {
		this.mesaAsociada = mesaAsociada;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public void save(){
		PedidoDao.getDao().save(this);
	}


	public PedidoDto toDto(){
		dto.PedidoDto PedidoDto = new PedidoDto();
		PedidoDto.setNumeroPedido(this.getNumeroPedido());
		PedidoDto.setCantComensales(this.getCantComensales());
		PedidoDto.setFechaApertura(this.getFechaApertura());
		PedidoDto.setFechaCierre(this.getFechaCierre());
		return PedidoDto;
	}
}
