package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PlanesDeProduccion")
public class PlanProduccion extends EntityClass {
	
	@Column(name = "estado")
	private String estado;
	
	@OneToMany
	@JoinColumn(name = "itemProduccion_id")
	private List<ItemPlanProduccion> items = new ArrayList<ItemPlanProduccion>();
	
	@Column(name = "fecha")
	private Date fecha;
}
