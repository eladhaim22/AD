package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name ="ItemsPlanProduccion")
public class ItemPlanProduccion extends EntityClass {
	
	@Column(name = "cantidadSolicitada")
	private float cantidadSolicitada;
	
	@Column(name = "cantidadProducida")
	private float cantidadProducida;
	
	@OneToOne
	@JoinColumn(name ="item_id")
	private ItemComplejo semiElaborado;
}
