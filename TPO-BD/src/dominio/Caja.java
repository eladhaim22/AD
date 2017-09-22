package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cajas")
public class Caja extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "caja_id")
	private List<Factura> facturas = new ArrayList<Factura>();
	
	@OneToMany
	@JoinColumn(name = "caja_id")
	private List<AsientoContable> asientosContables = new ArrayList<AsientoContable>();
	
	@OneToMany
	@JoinColumn(name = "caja_id")
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
}
