package dto;

import java.rmi.RemoteException;
import java.util.Vector;

public class VistaManifiesto implements IVistaManifiesto{
	private Vector<String> mercaderiasTransportadas;
	private String codigo;
	
	public Vector<String> getMercaderiasTransportadas() throws RemoteException{
		return mercaderiasTransportadas;
	}
	public void setMercaderiasTransportadas(Vector<String> mercaderiasTransportadas) throws RemoteException{
		this.mercaderiasTransportadas = mercaderiasTransportadas;
	}
	public String getCodigo() throws RemoteException{
		return codigo;
	}
	public void setCodigo(String codigo) throws RemoteException{
		this.codigo = codigo;
	}
	
		
}
