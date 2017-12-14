package model;

import javax.persistence.*;


public class IngredienteProducto extends Ingrediente {

	public IngredienteProducto(Integer ingredienteId, float cantidad, Stock stock, Producto 	productoAsociado) {
		super(ingredienteId, cantidad, stock);
		this.productoAsociado = productoAsociado;
	}

	private Producto productoAsociado;

	public Producto getProductoAsociado() {
		return productoAsociado;
	}

	public void setProductoAsociado(Producto productoAsociado) {
		this.productoAsociado = productoAsociado;
	}


}
