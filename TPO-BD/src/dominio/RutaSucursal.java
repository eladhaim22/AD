package dominio;





public class RutaSucursal {
	private Sucursal SucDestino;
	private Sucursal SucOrigen;
	private float duracion;
	private float Costo;
	private String descripcion;
	private boolean estado;
	public boolean estaActiva() {
		return true;
	}
	
	public float calcularCosto() {
		return 0;
	}
}
