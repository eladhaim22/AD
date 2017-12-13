package mappers;

import java.util.ArrayList;
import java.util.List;

import dominio.Mesa;
import dominio.Sector;
import dto.MesaDto;
import dto.SectorDto;

public class SectorMapper {
	
	private static SectorMapper mapper;
	
	 public static SectorMapper getMapper(){
	        if(mapper == null){
	            mapper = new SectorMapper();
	        }

	        return mapper;
	    }
	 
	 public SectorDto ToDto(Sector Sector){
		 	SectorDto SectorDto = new SectorDto();
		 	SectorDto.setNumeroSector(Sector.getNumeroSector());
		 	SectorDto.setNombre(Sector.getNombre());
		 	MesaMapper map = new MesaMapper();
		 	List<MesaDto> mesasDto = new ArrayList<MesaDto>();
		 	for(Mesa m : Sector.getMesas()){
		 		mesasDto.add(map.ToDto(m));
		 	}
		 	SectorDto.setMesas(mesasDto);
	        return SectorDto;
	    }

}
