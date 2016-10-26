package dominio;

import java.util.ArrayList;

public class ControladorMantenimiento {
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<PlanDeMantenimiento> planesDeMantenimiento;
	private ArrayList<Taller> talleres;
	private ArrayList<Tarea> tareas;
	/*public void altaVehiculoPropio(String registro, capacidadDeVolumen capacidad) {
	
	}*/
	
	public void bajaVehiculo(String registro) {
	
	}
	
	public void modificacionVehiculo(String registro) {
	
	}
	
	public void altaTaller(String domicilio, String codTaller, String nombre) {
	
	}
	
	public void bajaTaller(String codTaller) {
	
	}
	
	public void altaPlanDeMantenimiento(String nombre) {
	
	}
	
	public void bajaPlanDeMantenimiento(int codPlan) {
	
	}
	
	public void altaTarea(String nombre, String descripcion, String codTarea) {
	
	}
	
	public void bajaTarea(int codTarea) {
	
	}
	
	public void controlarMantenimiento() {
	
	}
	
	public void controlarEstadoVehiculos() {
	
	}
	
	public void controlarTipoMantenimiento() {
	
	}
	
	public Vehiculo buscarVehiculo(String registro) {
		return new VehiculoPropio();
	}
	
	public boolean existeVehiculo(String registro) {
		return true;
	}
	
	public Taller buscarTaller(String codTaller) {
		return new Taller();
	}
	
	public boolean existeTaller(String codTaller) {
		return true;
	}
}
