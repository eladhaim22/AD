package dominio;

import java.util.Date;

public class VehiculoPropio extends Vehiculo {
	private float kms;
	private Date modelo;
	private boolean estaEnGarantia;
	private PlanDeMantenimiento planDeMantenimiento;
	private boolean refrigerado;
	public boolean necesitaMantenimiento() {
		return true;
	}
	
	public boolean esVehiculo(String registro) {
		return true;
	}
	
	public boolean soyVehiculoApto() {
		return true;
	}
	

}