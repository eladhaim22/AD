package daos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.CartaEntity;
import entities.ItemCartaEntity;
import hbt.GenericDao;
import model.Carta;

public class CartaDao extends GenericDao<Carta,CartaEntity>{

	private static CartaDao dao;

    public static CartaDao getDao(){
        if(dao == null){
            dao = new CartaDao();
        }
        return dao;
    }
	
	@SuppressWarnings("unchecked")
	public List<CartaEntity> obtenerCartasPorSucursal(int sucursalId) {
		Date date = new Date();
		List<CartaEntity> list = getHibernateTemplate().createQuery("Select C from Sucursal S join S.cartas C where S.sucursalId = :sucursal_id and C.fechaInicio < :date and C.fechaFinal > :date")
				.setInteger("sucursal_id", sucursalId).setTimestamp("date", date).list();
		
		return list;	
	}

	@SuppressWarnings("unchecked")
	public List<ItemCartaEntity> obtenerItemCarta(int cartaId) {
		List<ItemCartaEntity> list = getHibernateTemplate().createQuery("Select I from Carta C join C.items I where C.cartaId = :cartaId")
				.setInteger("cartaId", cartaId).list();
		
		return list;
	}

	public ItemCartaEntity obtenerItemCartaById(int id) {
		ItemCartaEntity objetoEncontrado;
		objetoEncontrado = (ItemCartaEntity)getHibernateTemplate().get(ItemCartaEntity.class, id);
		
		return objetoEncontrado;
	}


	public CartaEntity toEntity(Carta carta) {
		CartaEntity cartaEntity = new CartaEntity(carta.getCartaId(),carta.getNombre(),carta.getFechaInicio(),carta.getFechaFinal(),carta.getActivo(),
				carta.getItems().stream().map(item -> ItemCartaDao.getDao().toEntity(item)).collect(Collectors.toSet()));
		return cartaEntity;
	}

	public Carta toNegocio(CartaEntity cartaEntity) {
		Carta carta = new Carta(cartaEntity.getCartaId(),cartaEntity.getNombre(),cartaEntity.getFechaInicio(),cartaEntity.getFechaFinal(),cartaEntity.getActivo(),
				cartaEntity.getItems().stream().map(item -> ItemCartaDao.getDao().toNegocio(item)).collect(Collectors.toSet()));
		return carta;
	}
}
