package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva extends EntityClass {
	
	@OneToMany 
	@JoinTable(name = "reservas_mesas", joinColumns= {
			@JoinColumn(name = "reserva_id")
	},inverseJoinColumns = {@JoinColumn(name = "mesa_id")})
	private List<Mesa> mesas = new ArrayList<Mesa>();
	
	@Column(name = "fechaReserva")
	private Date fechaReserva;
}
