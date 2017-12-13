package daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import dominio.Carta;
import dominio.ItemCarta;
import hbt.GenericDao;

public class CartaDao extends GenericDao<Carta>{

	private static CartaDao dao;

    public static CartaDao getDao(){
        if(dao == null){
            dao = new CartaDao();
        }
        return dao;
    }
	
	@SuppressWarnings("unchecked")
	public List<Carta> obtenerCartasPorSucursal(int sucursalId) {
		Date date = new Date();
		List<Carta> list = getHibernateTemplate().createQuery("Select C from Sucursal S join S.cartas C where S.sucursalId = :sucursal_id and C.fechaInicio < :date and C.fechaFinal > :date")
				.setInteger("sucursal_id", sucursalId).setTimestamp("date", date).list();
		
		return list;	
	}

	@SuppressWarnings("unchecked")
	public List<ItemCarta> obtenerItemCarta(int cartaId) {
		List<ItemCarta> list = getHibernateTemplate().createQuery("Select I from Carta C join C.items I where C.cartaId = :cartaId")
				.setInteger("cartaId", cartaId).list();
		
		return list;
	}

	public ItemCarta obtenerItemCartaById(int id) {
		ItemCarta objetoEncontrado;
		objetoEncontrado = (ItemCarta)getHibernateTemplate().get(ItemCarta.class, id);
		
		return objetoEncontrado;
	}
}
