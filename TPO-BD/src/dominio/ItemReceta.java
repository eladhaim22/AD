package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name ="ItemsReceta")
public class ItemReceta extends EntityClass {
	
	@OneToOne
	@JoinColumn(name ="item_id")
	private Item item;
	
	@Column(name = "cantidad")
	private float cantidad;
}
