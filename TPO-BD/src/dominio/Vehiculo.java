package dominio;

import java.util.ArrayList;

public abstract class Vehiculo {
	protected String registro;
	protected float capacidadDeVolumen;
	protected float peso;
	protected float tara;
	protected ArrayList<String> condicionesEsp;
	public abstract boolean esVehiculo(String registro);
	public boolean soyVehiculoApto() {
		return true;
	}
}
