package daos;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import entities.MesaEntity;
import entities.PedidoEntity;
import hbt.HibernateUtil;
import model.Pedido;
import org.hibernate.Session;

public class PedidoDao extends GenericDao<Pedido,PedidoEntity> {

	private static PedidoDao dao;

    public static PedidoDao getDao(){
        if(dao == null){
            dao = new PedidoDao();
        }
        return dao;
    }

	public Pedido buscarPorMesa(Integer numeroMesa){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PedidoEntity pedidoE = (PedidoEntity) session.createQuery("select p from Pedido p join p.mesaAsociada m where m.mesaId = :nroMesa and p.FechaCierre is null").setInteger("nroMesa",numeroMesa ).uniqueResult();
		Pedido pedido = this.toNegocio(pedidoE);
		session.close();
		return pedido;

	}

	public List<Pedido> listarPedidosDeHoy(int sucursalId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date datefrom = Date.from(instant);
		instant = Instant.now().plusSeconds(86400);
		instant = instant.truncatedTo(ChronoUnit.DAYS);
		Date dateto = Date.from(instant);	
		List<PedidoEntity> pedidosE = session.createQuery("select P from Pedido P where P.FechaCierre >= :dateFrom and P.FechaCierre < :dateTo and P.sucursal.sucursalId = :sucursalId")
				.setTimestamp("dateFrom", datefrom).setTimestamp("dateTo", dateto)
				.setInteger("sucursalId",sucursalId).list();
		List<Pedido> pedidos = new ArrayList<>();
		pedidosE.stream().map(pedidoEntity -> this.toNegocio(pedidoEntity)).collect(Collectors.toList());
		session.close();
        return pedidos;
	}

	@Override
	public PedidoEntity toEntity(Pedido pedido) {
		return new PedidoEntity(pedido.getNumeroPedido(),
				FacturaDao.getDao().toEntity(pedido.getFactura()),
				MozoDao.getDao().toEntity(pedido.getMozo()),pedido.getFechaApertura(),
				pedido.getFechaCierre(),pedido.getComandas().stream().map(comanda ->
				ComandaDao.getDao().toEntity(comanda)).collect(Collectors.toSet()),
				MesaDao.getDao().toEntity(pedido.getMesaAsociada()),
				SucursalDao.getDao().toEntity(pedido.getSucursal()));
	}

	@Override
	public Pedido toNegocio(PedidoEntity pedidoEntity) {
		return new Pedido(pedidoEntity.getNumeroPedido(),pedidoEntity.getCantComensales(),FacturaDao.getDao().toNegocio(pedidoEntity.getFactura()),
				MozoDao.getDao().toNegocio(pedidoEntity.getMozo()),pedidoEntity.getFechaApertura(),
				pedidoEntity.getFechaCierre(),pedidoEntity.getComandas().stream().map(comanda ->
				ComandaDao.getDao().toNegocio(comanda)).collect(Collectors.toSet()),
				MesaDao.getDao().toNegocio(pedidoEntity.getMesaAsociada()),
				SucursalDao.getDao().toNegocio(pedidoEntity.getSucursal()));
	}
}
