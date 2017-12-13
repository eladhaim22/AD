package mappers;

import dominio.Mozo;
import dto.MozoDto;

public class MozoMapper {
	
	private static MozoMapper mapper;
	
	 public static MozoMapper getMapper(){
	        if(mapper == null){
	            mapper = new MozoMapper();
	        }

	        return mapper;
	    }
	 
	 public MozoDto ToDto(Mozo Mozo){
		 	MozoDto MozoDto = new MozoDto();
		 	MozoDto.setNroUsuario(Mozo.getNroUsuario());
		 	MozoDto.setNombre(Mozo.getNombre());
		 	MozoDto.setPorcComision(Mozo.getPorcComision());
		 	MozoDto.setTipo("Mozo");
	        return MozoDto;
	    }

}
