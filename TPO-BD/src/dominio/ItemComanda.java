package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name ="ItemsComanda")
public class ItemComanda extends EntityClass {
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private ItemComplejo item;
	
	@Column(name = "cantidad")
	private float cantidad;
	
	@Column(name = "estado")
	private String estado;
}
