
package dominio;

import java.util.Date;

public class Ubicacion {
	private String registroVehiculo;
	private int numeroDeRemito;
	private Date fecha;
	private int longitud;
	private int latitud;
	public boolean esVehiculo(String registroVehiculo) {
		return true;
	}
}