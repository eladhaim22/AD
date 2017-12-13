package mappers;

import dominio.ItemPedido;
import dto.ItemPedidoDto;

public class ItemPedidoMapper {
	
	private static ItemPedidoMapper mapper;
	
	 public static ItemPedidoMapper getMapper(){
	        if(mapper == null){
	            mapper = new ItemPedidoMapper();
	        }

	        return mapper;
	    }
	 
	 public ItemPedidoDto ToDto(ItemPedido ItemPedido){
		 	ItemPedidoDto ItemPedidoDto = new ItemPedidoDto();
		 	ItemPedidoDto.setItemPedidoId(ItemPedido.getItemPedidoId());
		 	ItemPedidoDto.setCantidad(ItemPedido.getCantidad());
		 	ItemPedidoDto.setEstado(ItemPedido.getEstado());
		 	ItemCartaMapper map = new ItemCartaMapper();
		 	ItemPedidoDto.setItem(map.ToDto(ItemPedido.getItem()));
	        return ItemPedidoDto;
	    }

}
