package dominio;

import javax.persistence.*;

@Entity
@Table (name = "itemsPedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemPedidoId;
	@Column
	private Integer cantidad;
	@Column
	private String estado;
	
	@ManyToOne	
	private ItemCarta item;

	public Integer getItemPedidoId() {
		return itemPedidoId;
	}

	public void setItemPedidoId(Integer itemPedidoId) {
		this.itemPedidoId = itemPedidoId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ItemCarta getItem() {
		return item;
	}

	public void setItem(ItemCarta item) {
		this.item = item;
	}
}
