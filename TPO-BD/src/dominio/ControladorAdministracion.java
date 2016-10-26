package dominio;

import java.util.ArrayList;

public class ControladorAdministracion {
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;
	private ListaDePrecios listaPrecios;
	private CompaniaDeSeguro companiaDeSeguros;
	private ArrayList<Sucursal> sucursales;
	public void altaCliente(String cuit, String nombre, String calle, int numero, String descripcion) {
	
	}
	
	public void bajaCliente(String cuit) {
	
	}
	
	public void modificacionCliente(String cuit, Direccion direccion) {
	
	}
	
	public void altaEmpleado(String dni, String nombre, String cargo) {
	
	}
	
	public void bajaEmpleado(String dni) {
	
	}
	
	public void modificarEmpleado(String dni, String cargo) {
	
	}
	
	/*public CompaniaDeSeguro getCompania(String nombre) {
	
	}
	
	public ListaDePrecios getListaPrecios(int codEnvio) {
	
	}*/
	
	public void registrarNotificacion(String codNotificaion,String  notificacion) {
	
	}
	
	public void posicionVehiculos() {
	
	}
	
	public void controlarGarantiasVehiculos(String codVehiculo) {
	
	}
	
	public void controlarCC(String cuit) {
	
	}
	
	public void controlarProveedores(String codProveedor) {
	
	}
	
	public void altaListadePrecios(String codPrecio, float precio) {
	
	}
	
	public void bajaListadePrecios(String codPrecio) {
	
	}
	
	public void modificacionListadePrecios(String codPrecio) {
	
	}
	
	public void altaCompaniaSeguros(int codSeguro,String companiaSeguro, String cuit) {
	
	}
	
	public void bajaCompaniaSeguros(String codSeguro) {
	
	}
	
	public void modificacionCompaniaSeguros(String codSeguro) {
	
	}
	
	public void altaCompaniaSeguridad(String codCompaniaSeguridad, String CompaniaSeguridad, String cuit) {
	
	}
	
	public void bajaCompaniaSeguridad(String codSeguridad) {
	
	}
	
	public void modificacionMapa(String codMapa) {
	
	}
	
	public void validarTipoCliente(String cuit) {
	
	}
	
	public void validarPermisoCliente(String cuit ) {
	
	}
	
	public void controlarPermisoAvioneta(String nroPermiso) {
	
	}
	
	public void ControlarCuentaCliente(String cuit) {
	
	}
	
	public void modificarSucursal(int numero, String nombre, String direccion) {
	
	}
	
	public void altaSucursal(String direccion, String nombre) {
	
	}
	
	public void bajaSucursal(int numero) {
	
	}
	
	/*public SeguimientoDeVehiculo getSeguimiento(int numeroDeVehiculo) {
	
	}*/
}
