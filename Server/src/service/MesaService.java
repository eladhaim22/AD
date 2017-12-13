package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import daos.MesaDao;
import dominio.Mesa;
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
		List<Mesa> Mesas = MesaDao.getDao().ListarMesasDisponibles(sucursal_id,mozoId,cantComensales);
		Mesas = Mesas.stream().sorted(Comparator.comparing(Mesa::getCapacidad)).collect(Collectors.toList());
		List<MesaDto> MesasDto = new ArrayList<MesaDto>();
		
		if(Mesas.size()>0){
			for(Mesa m :Mesas){
				MesaDto MesaDto = MesaMapper.getMapper().ToDto(m);
				MesasDto.add(MesaDto);
			}
		} 
		commitAndCloseSession();
		return MesasDto;
	}

	public void cerrarMesa(int mesaId) {
		openSession();
		Mesa m = MesaDao.getDao().Buscar(mesaId);
		if(m!=null)
		{
			m.setEmpty(true);
			MesaDao.getDao().Actualizar(m);;
		}
		commitAndCloseSession();
	}	
	
}
