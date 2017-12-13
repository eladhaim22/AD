package daos;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import dominio.Mesa;
import dominio.Pedido;
import hbt.GenericDao;

public class PedidoDao extends GenericDao<Pedido> {

	private static PedidoDao dao;

    public static PedidoDao getDao(){
        if(dao == null){
            dao = new PedidoDao();
        }
        return dao;
    }

	public Pedido buscarPorMesa(Integer numeroMesa){
		Pedido pedido = (Pedido) getHibernateTemplate().createQuery("select p from Pedido p join p.mesaAsociada m where m.mesaId = :nroMesa and p.FechaCierre is null").setInteger("nroMesa",numeroMesa ).uniqueResult();
		return pedido;

	}

	public List<Pedido> listarPedidosDeHoy(List<Mesa> mesas) {
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date datefrom = Date.from(instant);
		instant = Instant.now().plusSeconds(86400);
		instant = instant.truncatedTo(ChronoUnit.DAYS);
		Date dateto = Date.from(instant);	
		List<Pedido> pedidos = getHibernateTemplate().createQuery("select P from Pedido P where P.FechaCierre >= :dateFrom and P.FechaCierre < :dateTo and P.mesaAsociada in (:mesas)")
				.setParameterList("mesas", mesas).setTimestamp("dateFrom", datefrom).setTimestamp("dateTo", dateto).list();
        return pedidos;
	}
	
	/*public void agregarItemPedido(Pedido p) {

		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.flush();
		session.getTransaction().commit();
		session.close();		
	}*/
}
