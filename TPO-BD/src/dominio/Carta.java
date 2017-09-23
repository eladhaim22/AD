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
@Table(name = "Cartas")
public class Carta extends EntityClass{
	
	@OneToMany
	@JoinColumn(name = "carta_id")
	private List<ItemCarta> itemsCarta = new ArrayList<ItemCarta>();
	
	@Column(name = "fechaVigencia")
	private Date fechaVigencia;
}
