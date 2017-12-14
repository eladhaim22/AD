package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import daos.PedidoDao;
import entities.ItemCartaEntity;
import entities.ComandaEntity;
import entities.PedidoEntity;
import dto.ComandaDto;
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
		PedidoEntity pedido = PedidoDao.getDao().buscarPorMesa(mesaId);
		PedidoDto pedidoDto = PedidoMapper.getMapper().ToDto(pedido);
		commitAndCloseSession();
		return pedidoDto;
	}

	public void agregarItemPedido(int pedidoId, List<ComandaDto> listItems) {
		openSession();
		PedidoEntity p = PedidoDao.getDao().buscar(pedidoId);
		p.getComandas().clear();
		Set<ComandaEntity> comandas = new HashSet<ComandaEntity>();
		for(ComandaDto i : listItems)
		{
			ComandaEntity ip = new ComandaEntity();
			ItemCartaEntity ic = new ItemCartaEntity();


			ic.setItemCartaId(i.getItem().getItemCartaId());
			ip.setItem(ic);
			ip.setCantidad(i.getCantidad());
			
			comandas.add(ip);
		}
		
		p.setComandas(comandas);
		
		PedidoDao.getDao().Actualizar(p);
		commitAndCloseSession();
	}

	public PedidoDto obtenerPedido(int pedidoId) {
		openSession();
		PedidoDto pedidoDto = PedidoMapper.getMapper().ToDto(PedidoDao.getDao().buscar(pedidoId));
		commitAndCloseSession();
		return pedidoDto;
	}	

}
