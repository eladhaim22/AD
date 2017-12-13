package dto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;


public interface IVistaManifiesto  extends Remote {
	
	public Vector<String> getMercaderiasTransportadas() throws RemoteException;
	public void setMercaderiasTransportadas(Vector<String> mercaderias) throws RemoteException;
	public String getCodigo() throws RemoteException;
	public void setCodigo(String codigo) throws RemoteException;
	
}
