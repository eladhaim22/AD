package dto;

import java.util.Vector;

public class VistaDestino implements IVistaDestino {

	private String direccionDestino;
	private Vector<String> destinatarios;
	private String ubicacion;
	
	public String getDireccionDestino() {
		return direccionDestino;
	}
	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	public Vector<String> getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(Vector<String> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
