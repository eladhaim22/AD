package dominio;

import java.util.ArrayList;

public class Taller {
	private ArrayList<Tarea> tareas;
	private boolean estado;
	private String domicilio;
	private String nombre;
	private ArrayList<VehiculoPropio> vehiculos;
	private String codTaller;
	public boolean esTaller(String codTaller) {
		return true;
	}
}