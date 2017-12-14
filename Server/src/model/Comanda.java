package model;

public class Comanda {

	public Comanda(Integer id, Integer cantidad, String estado, Pedido pedido, ItemCarta item) {
		this.id = id;
		this.cantidad = cantidad;
		this.estado = estado;
		this.pedido = pedido;
		this.item = item;
	}

	private Integer id;
	private Integer cantidad;
	private String estado;
	
	private Pedido pedido;
	
	private ItemCarta item;

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

	public ItemCarta getItem() {
		return item;
	}

	public void setItem(ItemCarta item) {
		this.item = item;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
