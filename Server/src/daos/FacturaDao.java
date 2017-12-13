package daos;

import dominio.Deposito;
import dominio.Factura;
import dominio.Pedido;
import hbt.GenericDao;
import net.sourceforge.jtds.jdbc.DateTime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

public class FacturaDao extends GenericDao<Factura> {

	private static FacturaDao dao;

    public static FacturaDao getDao(){
        if(dao == null){
            dao = new FacturaDao();
        }
        return dao;
    }
    
	public Factura buscarNumeroPedido(Integer numeroPedido) {
		Factura factura = (Factura) getHibernateTemplate().createQuery("select F from Pedido P join P.factura F where P.numeroPedido = :numeroPedido").setInteger("numeroPedido",numeroPedido ).uniqueResult();
		return factura;
	}

}
