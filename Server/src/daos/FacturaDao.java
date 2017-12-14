package daos;

import entities.FacturaEntity;
import hbt.GenericDao;
import model.Factura;
import model.ItemFactura;

import java.util.stream.Collectors;

public class FacturaDao extends GenericDao<Factura,FacturaEntity> {

	private static FacturaDao dao;

    public static FacturaDao getDao(){
        if(dao == null){
            dao = new FacturaDao();
        }
        return dao;
    }
    
	public FacturaEntity buscarNumeroPedido(Integer numeroPedido) {
		FacturaEntity factura = (FacturaEntity) getHibernateTemplate().createQuery("select F from Pedido P join P.factura F where P.numeroPedido = :numeroPedido").setInteger("numeroPedido",numeroPedido ).uniqueResult();
		return factura;
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
