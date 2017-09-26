package dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity 
@Table(name = "Items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "item")
public class Item extends EntityClass {
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "rubro")
	private String rubro;

	@Column(name = "venceEn")
	private Date venceEn; 
}
