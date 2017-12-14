package mappers;

import entities.ComandaEntity;
import dto.ComandaDto;

public class ComandaMapper {
	
	private static ComandaMapper mapper;
	
	 public static ComandaMapper getMapper(){
	        if(mapper == null){
	            mapper = new ComandaMapper();
	        }

	        return mapper;
	    }
	 
	 public ComandaDto ToDto(ComandaEntity comanda){
		 	ComandaDto comandaDto = new ComandaDto();
		 	comandaDto.setItemPedidoId(comanda.getId());
		 	comandaDto.setCantidad(comanda.getCantidad());
		 	comandaDto.setEstado(comanda.getEstado());
		 	ItemCartaMapper map = new ItemCartaMapper();
		 	comandaDto.setItem(map.ToDto(comanda.getItem()));
	        return comandaDto;
	    }

}
