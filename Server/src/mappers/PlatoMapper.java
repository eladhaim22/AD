package mappers;

import dominio.Plato;
import dto.PlatoDto;

public class PlatoMapper {
	
	private static PlatoMapper mapper;
	
	 public static PlatoMapper getMapper(){
	        if(mapper == null){
	            mapper = new PlatoMapper();
	        }

	        return mapper;
	    }
	 
	 public PlatoDto ToDto(Plato Plato){
		 	PlatoDto PlatoDto = new PlatoDto();
		 	PlatoDto.setPlatoId(Plato.getPlatoId());
		 	PlatoDto.setNombre(Plato.getNombre());
		 	PlatoDto.setUnidadMedida(Plato.getUnidadMedida());
		 	PlatoDto.setPorcionesXUnidad(Plato.getPorcionesXUnidad());
		 	PlatoDto.setComentarios(Plato.getComentarios());
	        return PlatoDto;
	    }

}
