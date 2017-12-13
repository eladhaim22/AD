package service;

import java.util.ArrayList;
import java.util.List;

import daos.SectorDao;
import dominio.Sector;
import dto.SectorDto;
import mappers.SectorMapper;

public class SectorService extends GenericService {
	
	private static SectorService instance;
	
	public static SectorService getInstance(){
		if (instance==null)
			instance = new SectorService();
		return instance;
	}

	public List<SectorDto> obtenerSectores() {
		openSession();
		List<Sector> sectores = SectorDao.getDao().ListarTodos();
		List<SectorDto> sectoresDto = new ArrayList<SectorDto>();
		
		if(sectores.size()>0){
			for(Sector s :sectores){
				SectorDto SectorDto = SectorMapper.getMapper().ToDto(s);
				sectoresDto.add(SectorDto);
			}
		}

		commitAndCloseSession();
		return sectoresDto;
	}

}
