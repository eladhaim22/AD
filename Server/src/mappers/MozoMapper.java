package mappers;

import entities.MozoEntity;
import dto.MozoDto;

public class MozoMapper {
	
	private static MozoMapper mapper;
	
	 public static MozoMapper getMapper(){
	        if(mapper == null){
	            mapper = new MozoMapper();
	        }

	        return mapper;
	    }
	 
	 public MozoDto ToDto(MozoEntity Mozo){
		 	MozoDto MozoDto = new MozoDto();
		 	MozoDto.setId(Mozo.getId());
		 	MozoDto.setNombre(Mozo.getNombre());
		 	MozoDto.setPorcComision(Mozo.getPorcComision());
		 	MozoDto.setTipo("Mozo");
	        return MozoDto;
	    }

}
