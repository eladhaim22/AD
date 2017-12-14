package entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("IP")
public class IngredienteProductoEntity extends IngredienteEntity {

	public IngredienteProductoEntity(int ingredienteId,float cantidad, StockEntity stock, ProductoEntity productoAsociado) {
		super(ingredienteId,cantidad, stock);
		this.productoAsociado = productoAsociado;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productoId")
	private ProductoEntity productoAsociado;

	public ProductoEntity getProductoAsociado() {
		return productoAsociado;
	}

	public void setProductoAsociado(ProductoEntity productoAsociado) {
		this.productoAsociado = productoAsociado;
	}

}
