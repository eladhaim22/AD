package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity 
@Table(name = "Areas")
public class Area extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "area_id")
	private List<Comanda> comandas = new ArrayList<Comanda>();
	
	@OneToOne
	@JoinColumn(name = "area_id")
	private Deposito deposito;
}
