package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.MesaDto;

public interface IAdminstracionService extends Remote {
	public List<MesaDto> obtenerMesa(int cant_personas) throws RemoteException;
}