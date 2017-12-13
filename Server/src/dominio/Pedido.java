package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroPedido;
	
	private Integer cantComensales;

	@OneToOne(cascade = CascadeType.ALL)
	private Factura factura;
	
	@OneToOne
	private Mozo mozo;
	
	private Date FechaApertura;

	private Date FechaCierre;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="numeroPedido")
	private List<ItemPedido> items = new ArrayList<ItemPedido>();
	
	@ManyToOne	 
	@JoinColumn(name="mesaId")
	private Mesa mesaAsociada;

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

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> list) {
		this.items = list;
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
	
	
}
