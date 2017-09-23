package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Mozos")
public class Mozo extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "mozo_id")
	private List<Mesa> mesas = new ArrayList<Mesa>();
}
