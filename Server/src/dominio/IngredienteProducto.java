package dominio;

import javax.persistence.*;


@Entity
@DiscriminatorValue("IP")
public class IngredienteProducto extends Ingrediente{
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productoId")
	private Producto productoAsociado;

	public Producto getProductoAsociado() {
		return productoAsociado;
	}

	public void setProductoAsociado(Producto productoAsociado) {
		this.productoAsociado = productoAsociado;
	}

	public IngredienteProducto() {
		super();
	}

}
