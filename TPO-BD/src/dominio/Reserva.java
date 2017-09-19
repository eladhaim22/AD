package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva extends EntityClass {
	private List<Mesa> mesas = new ArrayList<Mesa>();
	private Date fechaReserva;
}
