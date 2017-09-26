package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Salones")
public class Salon  extends EntityClass {
	@OneToMany
	@JoinColumn(name = "sector_id")
	private List<Sector> sectores = new ArrayList<Sector>();
}
