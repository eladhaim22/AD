package service;

import java.util.ArrayList;
import java.util.List;

import daos.CartaDao;
import dominio.Carta;
import dominio.ItemCarta;
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
		List<Carta> cartas = new CartaDao().obtenerCartasPorSucursal(sucursalId);
		List<CartaDto> cartasDto = new ArrayList<CartaDto>();
		CartaMapper map = new CartaMapper();
		
		for(Carta c : cartas){
			cartasDto.add(map.ToDto(c));
		}
		commitAndCloseSession();
		return cartasDto;
	}

	public List<ItemCartaDto> obtenerItemCarta(int cartaId) {
		openSession();
		List<ItemCarta> items = CartaDao.getDao().obtenerItemCarta(cartaId);
		List<ItemCartaDto> itemsDto = new ArrayList<ItemCartaDto>();
		
		for(ItemCarta i : items){
			itemsDto.add(ItemCartaMapper.getMapper().ToDto(i));
		}
		commitAndCloseSession();
		return itemsDto;
	}

	public ItemCartaDto obtenerItemCartaById(int id) {
		openSession();
		ItemCarta item = CartaDao.getDao().obtenerItemCartaById(id);
		ItemCartaDto itemCartaDto = ItemCartaMapper.getMapper().ToDto(item);
		commitAndCloseSession();
		return itemCartaDto;
	}
	
}
