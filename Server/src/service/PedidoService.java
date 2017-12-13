package service;

import java.util.ArrayList;
import java.util.List;

import daos.PedidoDao;
import dominio.ItemCarta;
import dominio.ItemPedido;
import dominio.Pedido;
import dto.ItemPedidoDto;
import dto.PedidoDto;
import mappers.PedidoMapper;

public class PedidoService extends GenericService{
	
	private static PedidoService instance;
	
	public static PedidoService getInstance(){
		if (instance==null)
			instance = new PedidoService();
		return instance;
	}

	public PedidoDto obtenerPedidoPorMesa(int mesaId) {
		openSession();
		Pedido pedido = PedidoDao.getDao().buscarPorMesa(mesaId);
		PedidoDto pedidoDto = PedidoMapper.getMapper().ToDto(pedido);
		commitAndCloseSession();
		return pedidoDto;
	}

	public void agregarItemPedido(int pedidoId, List<ItemPedidoDto> listItems) {
		openSession();
		Pedido p = PedidoDao.getDao().Buscar(pedidoId);
		
		List<ItemPedido> list = new ArrayList<ItemPedido>();
		for(ItemPedidoDto i : listItems)
		{
			ItemPedido ip = new ItemPedido();
			ItemCarta ic = new ItemCarta();
			
			ic.setItemCartaId(i.getItem().getItemCartaId());
			ip.setItem(ic);
			ip.setCantidad(i.getCantidad());
			
			list.add(ip);
		}
		
		p.setItems(list);
		
		PedidoDao.getDao().Actualizar(p);
		commitAndCloseSession();
	}

	public PedidoDto obtenerPedido(int pedidoId) {
		openSession();
		PedidoDto pedidoDto = PedidoMapper.getMapper().ToDto(PedidoDao.getDao().Buscar(pedidoId));
		commitAndCloseSession();
		return pedidoDto;
	}	

}
