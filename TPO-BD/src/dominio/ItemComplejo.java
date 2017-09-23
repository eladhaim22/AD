package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "itemComplejo")
public class ItemComplejo extends Item {
	
	@OneToOne
	@JoinColumn(name = "receta_id")
	private Receta receta;
}
