package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "facturas")
public class FacturaEntity {

	public FacturaEntity(int numeroFactura,Date fecha, float monto, String medioPago, boolean pagado, Set<ItemFacturaEntity> itemsFactura) {
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		Monto = monto;
		this.medioPago = medioPago;
		this.pagado = pagado;
		this.itemsFactura = itemsFactura;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroFactura;
	
	private Date fecha;
	
	private float Monto;

	private String medioPago;
	
	private boolean pagado;
	
	@OneToMany
	@JoinTable(name="factura_id")
	private Set<ItemFacturaEntity> itemsFactura = new HashSet<>();


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
	public Set<ItemFacturaEntity> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(Set<ItemFacturaEntity> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}

	
}