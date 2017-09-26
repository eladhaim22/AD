package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sectores")
public class Sector extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "sector_id")
	private List<Mesa> tables = new ArrayList<Mesa>();
}
