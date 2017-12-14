package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import daos.MesaDao;
import entities.MesaEntity;
import dto.MesaDto;
import mappers.MesaMapper;

public class MesaService extends GenericService {

	private static MesaService instance;
	
	public static MesaService getInstance(){
		if (instance==null)
			instance = new MesaService();
		return instance;
	}
	
	public List<MesaDto> obtenerMesasDisponibles(int sucursal_id, int mozoId, int cantComensales) {
		openSession();
		List<MesaEntity> Mesas = MesaDao.getDao().ListarMesasDisponibles(sucursal_id,mozoId,cantComensales);
		Mesas = Mesas.stream().sorted(Comparator.comparing(MesaEntity::getCapacidad)).collect(Collectors.toList());
		List<MesaDto> MesasDto = new ArrayList<MesaDto>();
		
		if(Mesas.size()>0){
			for(MesaEntity m :Mesas){
				MesaDto MesaDto = MesaMapper.getMapper().ToDto(m);
				MesasDto.add(MesaDto);
			}
		} 
		commitAndCloseSession();
		return MesasDto;
	}

	public void cerrarMesa(int mesaId) {
		openSession();
		MesaEntity m = MesaDao.getDao().buscar(mesaId);
		if(m!=null)
		{
			m.setEmpty(true);
			MesaDao.getDao().Actualizar(m);;
		}
		commitAndCloseSession();
	}	
	
}
