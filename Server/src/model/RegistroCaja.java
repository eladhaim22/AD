package model;

import daos.FacturaDao;
import daos.RegistroCajaDao;
import dto.RegistroCajaDto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class RegistroCaja {
	public RegistroCaja(Integer id, Sucursal sucursal, Date date, double valorCaja, double valorEsperado) {
		this.id = id;
		this.sucursal = sucursal;
		this.date = date;
		this.valorCaja = valorCaja;
		this.valorEsperado = valorEsperado;
	}

	private Integer id;
	private Sucursal sucursal;
	private Date date;
	private double valorCaja;
	private double valorEsperado;

	public RegistroCaja(Sucursal sucursal,double valorCaja) {
		this.date= Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS));
		this.sucursal=sucursal;
		this.valorCaja=valorCaja;
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValorCaja() {
		return valorCaja;
	}

	public void setValorCaja(double valorCaja) {
		this.valorCaja = valorCaja;
	}

	public double getValorEsperado() {
		return valorEsperado;
	}

	public void setValorEsperado(double valorTotal) {
		this.valorEsperado = valorTotal;
	}

	public void save(){
		RegistroCajaDao.getDao().save(this);
	}

	public RegistroCaja cerrarCaja(int sucursalId){
		List<Factura> facturas = FacturaDao.getDao().obtenerFacturasDeHoy(sucursalId);
		this.valorEsperado = facturas.stream().mapToDouble(factura -> factura.getMonto()).sum();
		save();
		return this;
	}

	public RegistroCajaDto toDto(){
		return new RegistroCajaDto(this.id,this.sucursal.getSucursalId(),this.getDate(),this.getValorCaja(),this.getValorEsperado());
	}


}
