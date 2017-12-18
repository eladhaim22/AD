package daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import entities.CartaEntity;
import entities.ItemCartaEntity;
import hbt.HibernateUtil;
import model.Carta;
import model.ItemCarta;
import org.hibernate.Session;

public class CartaDao extends GenericDao<Carta,CartaEntity>{

	private static CartaDao dao;

    public static CartaDao getDao(){
        if(dao == null){
            dao = new CartaDao();
        }
        return dao;
    }

	public List<Carta> obtenerCartasPorSucursal(int sucursalId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Date date = new Date();
		List<CartaEntity> listE = session.createQuery("Select C from SucursalEntity S join S.cartas C where S.sucursalId = :sucursal_id and C.fechaInicio < :date and C.fechaFinal > :date")
				.setInteger("sucursal_id", sucursalId).setTimestamp("date", date).list();
		List<Carta> cartas = new ArrayList<>();
		cartas.addAll(listE.stream().map(cartaEntity -> this.toNegocio(cartaEntity)).collect(Collectors.toList()));
		session.close();
		return cartas;
	}

	public CartaEntity toEntity(Carta carta) {
		return carta == null ? null : new CartaEntity(carta.getCartaId(),carta.getNombre(),carta.getFechaInicio(),carta.getFechaFinal(),carta.getActivo(),
				carta.getItems().stream().map(item -> ItemCartaDao.getDao().toEntity(item)).collect(Collectors.toSet()));
	}

	public Carta toNegocio(CartaEntity cartaEntity) {
		return cartaEntity == null ? null : new Carta(cartaEntity.getCartaId(),cartaEntity.getNombre(),cartaEntity.getFechaInicio(),cartaEntity.getFechaFinal(),cartaEntity.getActivo(),
				cartaEntity.getItems().stream().map(item -> ItemCartaDao.getDao().toNegocio(item)).collect(Collectors.toSet()));
	}
}
