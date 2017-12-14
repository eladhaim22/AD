package entities;

import javax.persistence.*;

@Entity
@Table (name = "comandas")
public class ComandaEntity {

	public ComandaEntity(int id,Integer cantidad, String estado, PedidoEntity pedido, ItemCartaEntity item) {
		this.id = id;
		this.cantidad = cantidad;
		this.estado = estado;
		this.pedido = pedido;
		this.item = item;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private Integer cantidad;
	@Column
	private String estado;
	
	@ManyToOne
	private PedidoEntity pedido;
	
	@ManyToOne	
	private ItemCartaEntity item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ItemCartaEntity getItem() {
		return item;
	}

	public void setItem(ItemCartaEntity item) {
		this.item = item;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
}
