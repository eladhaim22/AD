package daos;

import entities.FacturaEntity;
import hbt.HibernateUtil;
import model.Factura;
import org.hibernate.Session;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FacturaDao extends GenericDao<Factura,FacturaEntity> {

	private static FacturaDao dao;

    public static FacturaDao getDao(){
        if(dao == null){
            dao = new FacturaDao();
        }
        return dao;
    }
    
	public Factura buscarNumeroPedido(Integer numeroPedido) {
        Factura factura = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        FacturaEntity facturaE =  (FacturaEntity) session.createQuery("select F from PedidoEntity P join P.factura F where P.numeroPedido = :numeroPedido").setInteger("numeroPedido",numeroPedido ).uniqueResult();
        factura = this.toNegocio(facturaE);
        session.close();
		return factura;
	}

    public List<Factura> obtenerFacturasDeHoy(int sucursalId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
        Date datefrom = Date.from(instant);
        instant = Instant.now().plusSeconds(86400);
        instant = instant.truncatedTo(ChronoUnit.DAYS);
        Date dateto = Date.from(instant);
        List<FacturaEntity> facturasE = session.createQuery("select F from PedidoEntity P join P.factura F where P.FechaCierre >= :dateFrom and P.FechaCierre < :dateTo and P.sucursal.sucursalId = :sucursalId")
                .setTimestamp("dateFrom", datefrom).setTimestamp("dateTo", dateto)
                .setInteger("sucursalId",sucursalId).list();
        List<Factura> facturas = new ArrayList<>();
        facturas.addAll(facturasE.stream().map(fe -> this.toNegocio(fe)).collect(Collectors.toList()));
        session.close();
        return facturas;
    }

    public FacturaEntity toEntity(Factura factura) {
        return new FacturaEntity(factura.getNumeroFactura(),factura.getFecha(),factura.getMonto(),factura.getMedioPago(),factura.isPagado(),factura.getItemsFactura().stream().map(itemFactura ->
                ItemFacturaDao.getDao().toEntity(itemFactura)).collect(Collectors.toSet())
        );
    }

    public Factura toNegocio(FacturaEntity facturaEntity) {
        return new Factura(facturaEntity.getNumeroFactura(),facturaEntity.getFecha(),facturaEntity.getMonto(),facturaEntity.getMedioPago(),facturaEntity.isPagado(),facturaEntity.getItemsFactura().stream().map(itemFactura ->
                ItemFacturaDao.getDao().toNegocio(itemFactura)).collect(Collectors.toSet())
        );
    }
}
