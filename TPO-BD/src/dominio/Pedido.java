package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Pedido extends EntityClass {
	
	@OneToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;
	
	@OneToMany 
	@JoinTable(name = "Pediod_Item", joinColumns= {
			@JoinColumn(name = "pedido_id")
	},inverseJoinColumns = {@JoinColumn(name = "item_id")})
	private List<Item> items = new ArrayList<Item>();
	
}
