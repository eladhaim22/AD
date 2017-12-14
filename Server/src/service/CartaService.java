package service;

import java.util.ArrayList;
import java.util.List;

import daos.CartaDao;
import entities.CartaEntity;
import entities.ItemCartaEntity;
import dto.CartaDto;
import dto.ItemCartaDto;
import mappers.CartaMapper;
import mappers.ItemCartaMapper;

public class CartaService extends GenericService{

	private static CartaService instance;
	
	public static CartaService getInstance(){
		if (instance==null)
			instance = new CartaService();
		return instance;
	}

	public List<CartaDto> obtenerCartasPorSucursal(int sucursalId) {
		openSession();
		List<CartaEntity> cartas = new CartaDao().obtenerCartasPorSucursal(sucursalId);
		List<CartaDto> cartasDto = new ArrayList<CartaDto>();
		CartaMapper map = new CartaMapper();
		
		for(CartaEntity c : cartas){
			cartasDto.add(map.ToDto(c));
		}
		commitAndCloseSession();
		return cartasDto;
	}

	public List<ItemCartaDto> obtenerItemCarta(int cartaId) {
		openSession();
		List<ItemCartaEntity> items = CartaDao.getDao().obtenerItemCarta(cartaId);
		List<ItemCartaDto> itemsDto = new ArrayList<ItemCartaDto>();
		
		for(ItemCartaEntity i : items){
			itemsDto.add(ItemCartaMapper.getMapper().ToDto(i));
		}
		commitAndCloseSession();
		return itemsDto;
	}

	public ItemCartaDto obtenerItemCartaById(int id) {
		openSession();
		ItemCartaEntity item = CartaDao.getDao().obtenerItemCartaById(id);
		ItemCartaDto itemCartaDto = ItemCartaMapper.getMapper().ToDto(item);
		commitAndCloseSession();
		return itemCartaDto;
	}
	
}
