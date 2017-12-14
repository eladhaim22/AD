package dto;

import java.io.Serializable;

public class ComandaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer itemPedidoId;
	private Integer cantidad;
	private String estado;
	private ItemCartaDto item;
	
	
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
	public ItemCartaDto getItem() {
		return item;
	}
	public void setItem(ItemCartaDto item) {
		this.item = item;
	}

}