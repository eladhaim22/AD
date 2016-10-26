package dto;

import java.rmi.Remote;
import java.util.Vector;


public interface IVistaDestino  extends Remote {
	public String getDireccionDestino();
	public void setDireccionDestino(String direccion);
	public Vector<String> getDestinatarios();
	public void setDestinatarios(Vector<String> destinatarios);
	public String getUbicacion();
	public void setUbicacion(String ubicacion);
}
