package dominio;

import javax.persistence.*;

@Entity
@Table(name="itemDeposito")
public class ItemDeposito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemDepositoId;
	
	private Integer cantidad;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loteId")	
	private Lote lote;

	public Integer getItemDepositoId() {
		return itemDepositoId;
	}

	public void setItemDepositoId(Integer itemDepositoId) {
		this.itemDepositoId = itemDepositoId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

}
