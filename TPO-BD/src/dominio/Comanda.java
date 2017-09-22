package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comandas")
public class Comanda extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "comanda_id")
	private List<ItemComanda> itemsComanda = new ArrayList<ItemComanda>();
	
	@OneToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "estado")
	private String estado;
}
