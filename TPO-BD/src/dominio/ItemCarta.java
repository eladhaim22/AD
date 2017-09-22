package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemsCarta")
public class ItemCarta extends EntityClass {
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private ItemComplejo item;
	
	@Column(name = "precio")
	private float precio;
	
	@Column(name = "rubro")
	private String rubro;
}
