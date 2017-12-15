package model;

import dto.CartaDto;
import sun.text.resources.ar.CollationData_ar;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Carta {

	public Carta(Integer cartaId, String nombre, Date fechaInicio, Date fechaFinal, boolean activo, 		Set<ItemCarta> items) {
		this.cartaId = cartaId;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.activo = activo;
		this.items = items;
	}

	private Integer cartaId;
	
	private String nombre;
	
	private Date fechaInicio;
	
	private Date fechaFinal;
	
	private boolean activo;
	
	private Set <ItemCarta> items = new HashSet<ItemCarta>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio2) {
		this.fechaInicio = fechaInicio2;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<ItemCarta> getItems() {
		return items;
	}

	public void setItems(Set<ItemCarta> items) {
		this.items = items;
	}

	public void agregarItem(ItemCarta newItem){
		items.add(newItem);
	}

	public Integer getCartaId() {
		return cartaId;
	}

	public void setCartaId(Integer cartaId) {
		this.cartaId = cartaId;
	}

	public CartaDto toDto(){
		CartaDto CartaDto = new CartaDto();
		CartaDto.setCartaId(this.cartaId);
		CartaDto.setNombre(this.nombre);
		CartaDto.setFechaInicio(this.fechaInicio);
		CartaDto.setFechaFinal(this.fechaFinal);
		CartaDto.setItemCartaDtos(this.items.stream().map(itemCarta -> itemCarta.toDto()).collect(Collectors.toList()));
		return CartaDto;
	}
	
}
