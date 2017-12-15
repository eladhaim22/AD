package model;

import daos.RegistroCajaDao;

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

    public RegistroCaja() {

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

	public Double cerrarCaja(List<Factura> facturas){
		this.valorCaja = facturas.stream().mapToDouble(factura -> factura.getMonto()).sum();
		save();
		return this.valorCaja;
	}

}
