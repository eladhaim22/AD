package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

import daos.MesaDao;
import dto.MesaDto;
import mappers.MesaMapper;
import remoto.IAdminstracionService;

public class AdminstracionService extends UnicastRemoteObject implements IAdminstracionService {
	private MesaMapper mesaMapper;

	public AdminstracionService() throws RemoteException {
		super();
		this.mesaMapper = MesaMapper.getMapper();
	}

	public List<MesaDto> obtenerMesa(int cant_personas) throws RemoteException {
		return MesaDao.getDao().ListarMesasDisponibles().stream().map(mesa -> mesaMapper.ToDto(mesa)).collect(Collectors.toList());
	}
}
