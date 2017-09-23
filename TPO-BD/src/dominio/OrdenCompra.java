package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrdenesDeCompra")
public class OrdenCompra  extends EntityClass {
	
	@OneToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;
	
	@OneToMany
	@JoinColumn(name = "ordenCompra_id")
	private List<ItemOrdenCompra> items = new ArrayList<ItemOrdenCompra>();
}
