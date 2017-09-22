package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="recetas")
public class Receta  extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "receta_id")
	private List<ItemReceta> itemsReceta = new ArrayList<ItemReceta>();
	
	@Column(name = "tiempo")
	private float tiempo;
}
