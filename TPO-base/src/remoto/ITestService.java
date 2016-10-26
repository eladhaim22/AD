package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import dto.TestDto;

/*public interface ISucursal extends Remote {
      public Date recibirPedidoClienteParticular(IVistaManifiesto manifiesto, IVistaDestino destino )  throws RemoteException;; 
      public void ingresarDatosParaDespachoMercaderia( IVistaDestino despacho) throws RemoteException; 
      public void ingresarFechaMaximaDeArriboADestino( String fecha ) throws RemoteException;
      public void seDespachaMercaderiaEnSucursal(boolean seDespachaEnSucursal)  throws RemoteException;
      public boolean ingresarDatosCarga(String direccionCarga, String fecha, float horaMinima, float horamaxima) throws RemoteException;
      public void abonarPedido(float monto)  throws RemoteException;
}*/

public interface ITestService extends Remote {
	public void envioTest(TestDto test)throws RemoteException;	 
}