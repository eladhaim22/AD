package mappers;

import entities.ItemCartaEntity;
import dto.ItemCartaDto;

public class ItemCartaMapper {
	
	private static ItemCartaMapper mapper;
	
	 public static ItemCartaMapper getMapper(){
	        if(mapper == null){
	            mapper = new ItemCartaMapper();
	        }

	        return mapper;
	    }
	 
	 public ItemCartaDto ToDto(ItemCartaEntity ItemCarta){
		 	ItemCartaDto ItemCartaDto = new ItemCartaDto();
		 	ItemCartaDto.setItemCartaId(ItemCarta.getItemCartaId());
		 	ItemCartaDto.setPrecio(ItemCarta.getPrecio());
		 	PlatoMapper map= new PlatoMapper();
		 	ItemCartaDto.setPlatoAsociado(map.ToDto(ItemCarta.getPlatoAsociado()));
		 	ItemCartaDto.setAdicionalComision(ItemCarta.getAdicionalComision());
	        return ItemCartaDto;
	    }

}
