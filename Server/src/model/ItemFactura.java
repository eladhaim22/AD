package model;

import dto.ItemFacturaDto;


public class ItemFactura {

	public ItemFactura(Integer id, String nombrePlato, float cantidad, float precio) {
		this.id = id;
		this.nombrePlato = nombrePlato;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	private Integer id;
	private String nombrePlato;
	private float cantidad;
	private float precio;
	
	public ItemFactura (float cantidad,String nombre,float precio) {
    	this.nombrePlato=nombre;
    	this.cantidad=cantidad;
    	this.precio=precio;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombrePlato() {
		return nombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ItemFacturaDto toDto(){
    	return new ItemFacturaDto(this.getId(),this.getNombrePlato(),this.getCantidad(),
				this.getPrecio());
	}
	
	public float totalItemFactura(){
		return this.cantidad*this.precio;
	}
}
