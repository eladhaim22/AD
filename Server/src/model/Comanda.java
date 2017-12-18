package model;

import daos.ComandaDao;
import dto.ComandaDto;

public class Comanda {

	public Comanda(Integer id, Integer cantidad, String estado, ItemCarta item) {
		this.id = id;
		this.cantidad = cantidad;
		this.estado = estado;
		this.item = item;
	}

	private Integer id;
	private Integer cantidad;
	private String estado;

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

	public ComandaDto toDto(){
		ComandaDto comandaDto = new ComandaDto();
		comandaDto.setItemPedidoId(this.getId());
		comandaDto.setCantidad(this.getCantidad());
		comandaDto.setEstado(this.getEstado());
		comandaDto.setItem(this.getItem().toDto());
		return comandaDto;
	}

	public void save(){
		ComandaDao.getDao().save(this);
	}

	public void update(){
		ComandaDao.getDao().update(this);
	}
}
