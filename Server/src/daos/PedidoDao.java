package daos;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import entities.MesaEntity;
import entities.PedidoEntity;
import hbt.GenericDao;
import model.Pedido;

public class PedidoDao extends GenericDao<Pedido,PedidoEntity> {

	private static PedidoDao dao;

    public static PedidoDao getDao(){
        if(dao == null){
            dao = new PedidoDao();
        }
        return dao;
    }

	public PedidoEntity buscarPorMesa(Integer numeroMesa){
		PedidoEntity pedido = (PedidoEntity) getHibernateTemplate().createQuery("select p from Pedido p join p.mesaAsociada m where m.mesaId = :nroMesa and p.FechaCierre is null").setInteger("nroMesa",numeroMesa ).uniqueResult();
		return pedido;

	}

	public List<PedidoEntity> listarPedidosDeHoy(List<MesaEntity> mesas) {
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date datefrom = Date.from(instant);
		instant = Instant.now().plusSeconds(86400);
		instant = instant.truncatedTo(ChronoUnit.DAYS);
		Date dateto = Date.from(instant);	
		List<PedidoEntity> pedidos = getHibernateTemplate().createQuery("select P from Pedido P where P.FechaCierre >= :dateFrom and P.FechaCierre < :dateTo and P.mesaAsociada in (:mesas)")
				.setParameterList("mesas", mesas).setTimestamp("dateFrom", datefrom).setTimestamp("dateTo", dateto).list();
        return pedidos;
	}

	@Override
	public PedidoEntity toEntity(Pedido pedido) {
		return new PedidoEntity(pedido.getNumeroPedido(),
				FacturaDao.getDao().toEntity(pedido.getFactura()),
				MozoDao.getDao().toEntity(pedido.getMozo()),pedido.getFechaApertura(),
				pedido.getFechaCierre(),pedido.getComandas().stream().map(comanda ->
				ComandaDao.getDao().toEntity(comanda)).collect(Collectors.toSet()),
				MesaDao.getDao().toEntity(pedido.getMesaAsociada()));
	}

	@Override
	public Pedido toNegocio(PedidoEntity pedidoEntity) {
		return new Pedido(pedidoEntity.getNumeroPedido(),pedidoEntity.getCantComensales(),FacturaDao.getDao().toNegocio(pedidoEntity.getFactura()),
				MozoDao.getDao().toNegocio(pedidoEntity.getMozo()),pedidoEntity.getFechaApertura(),
				pedidoEntity.getFechaCierre(),pedidoEntity.getComandas().stream().map(comanda ->
				ComandaDao.getDao().toNegocio(comanda)).collect(Collectors.toSet()),
				MesaDao.getDao().toNegocio(pedidoEntity.getMesaAsociada()));
	}
}
