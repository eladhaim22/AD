package entities;

import model.Sucursal;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="pedidos")
public class PedidoEntity{

	public PedidoEntity() {
	}

	public PedidoEntity(Integer cantComensales, FacturaEntity factura, MozoEntity mozo, Date fechaApertura, Date fechaCierre, Set<ComandaEntity> comandas, MesaEntity mesaAsociada, SucursalEntity sucursal) {
		this.cantComensales = cantComensales;
		this.factura = factura;
		this.mozo = mozo;
		FechaApertura = fechaApertura;
		FechaCierre = fechaCierre;
		this.comandas = comandas;
		this.mesaAsociada = mesaAsociada;
		this.sucursal = sucursal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroPedido;
	
	private Integer cantComensales;

	@OneToOne(cascade = CascadeType.ALL)
	private FacturaEntity factura;
	
	@OneToOne
	@JoinColumn(name="mozo_id")
	private MozoEntity mozo;
	
	private Date FechaApertura;

	private Date FechaCierre;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="numeroPedido")
	private Set<ComandaEntity> comandas = new HashSet<ComandaEntity>();
	
	@ManyToOne	 
	@JoinColumn(name="mesaId")
	private MesaEntity mesaAsociada;

	@OneToOne
	private SucursalEntity sucursal;

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

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
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

	public Set<ComandaEntity> getComandas() {
		return comandas;
	}

	public void setComandas(Set<ComandaEntity> comandas) {
		this.comandas = comandas;
	}

	public MesaEntity getMesaAsociada() {
		return mesaAsociada;
	}

	public void setMesaAsociada(MesaEntity mesaAsociada) {
		this.mesaAsociada = mesaAsociada;
	}

	public MozoEntity getMozo() {
		return mozo;
	}

	public void setMozo(MozoEntity mozo) {
		this.mozo = mozo;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}
}
