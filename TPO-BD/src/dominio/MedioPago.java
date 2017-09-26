package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MediosDePago")
public class MedioPago extends EntityClass {
	
	@Column(name = "type")
	private String type;
}
