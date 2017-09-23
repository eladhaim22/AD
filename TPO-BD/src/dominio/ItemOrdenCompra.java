package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name ="itemsOrdenCompra")
public class ItemOrdenCompra extends EntityClass {
	
	@OneToOne
	@JoinColumn(name ="item_id")
	private Item insumo;
	
	@Column(name = "cantidad")
	private float cantidad;
}
