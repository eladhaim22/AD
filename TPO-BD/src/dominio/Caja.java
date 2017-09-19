package dominio;

import java.util.ArrayList;
import java.util.List;

public class Caja extends EntityClass {
	private List<Factura> facturas = new ArrayList<Factura>();
	private List<AsientoContable> asientosContables = new ArrayList<AsientoContable>();
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
}
