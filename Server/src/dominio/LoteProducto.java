package dominio;

import javax.persistence.*;

@Entity
@Table(name="loteProducto")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="loteId")
public class LoteProducto extends Lote{

	@ManyToOne
	@JoinColumn(name="productoId")	
	private Producto producto;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
