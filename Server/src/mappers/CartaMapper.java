package mappers;

import dominio.Carta;
import dto.CartaDto;


public class CartaMapper {
	
	private static CartaMapper mapper;
	
	 public static CartaMapper getMapper(){
	        if(mapper == null){
	            mapper = new CartaMapper();
	        }
	        return mapper;
	    }
	 
	 public CartaDto ToDto(Carta Carta){
		 	CartaDto CartaDto = new CartaDto();
		 	CartaDto.setCartaId(Carta.getCartaId());
		 	CartaDto.setNombre(Carta.getNombre());
		 	CartaDto.setFechaInicio(Carta.getFechaInicio());
		 	CartaDto.setFechaFinal(Carta.getFechaFinal());
	        return CartaDto;
	    }

}
