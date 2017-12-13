package dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="RegistroSCaja")
public class RegistroCaja {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Sucursal sucursal;
	
	private Date date;
	
	private double valorCaja;
	
	private double valorEsperado;

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

}
