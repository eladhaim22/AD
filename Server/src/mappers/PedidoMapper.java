package mappers;

import entities.PedidoEntity;
import dto.PedidoDto;

public class PedidoMapper {
	
	private static PedidoMapper mapper;
	
	 public static PedidoMapper getMapper(){
	        if(mapper == null){
	            mapper = new PedidoMapper();
	        }

	        return mapper;
	    }
	 
	 public PedidoDto ToDto(PedidoEntity Pedido){
		 	dto.PedidoDto PedidoDto = new PedidoDto();
		 	PedidoDto.setNumeroPedido(Pedido.getNumeroPedido());
		 	PedidoDto.setCantComensales(Pedido.getCantComensales());
		 	PedidoDto.setFechaApertura(Pedido.getFechaApertura());
		 	PedidoDto.setFechaCierre(Pedido.getFechaCierre());
	        return PedidoDto;
	    }

}
