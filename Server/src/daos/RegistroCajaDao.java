package daos;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;

import dominio.Carta;
import dominio.Factura;
import dominio.ItemCarta;
import dominio.Mesa;
import dominio.Pedido;
import dominio.RegistroCaja;
import hbt.GenericDao;

public class RegistroCajaDao extends GenericDao<RegistroCaja>{

	private static RegistroCajaDao dao;

    public static RegistroCajaDao getDao(){
        if(dao == null){
            dao = new RegistroCajaDao();
        }
        return dao;
    }
	
    public double calcualrValorCajaEsperado(List<Mesa> mesas) {
    	Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date datefrom = Date.from(instant);
		instant = Instant.now().plusSeconds(86400);
		instant = instant.truncatedTo(ChronoUnit.DAYS);
		Date dateto = Date.from(instant);
		List<Factura> facturas = getHibernateTemplate().createQuery("select F from Pedido P join P.factura F where P.FechaCierre >= :dateFrom and P.FechaCierre < :dateTo and P.mesaAsociada in (:mesas)")
				.setParameterList("mesas", mesas).setTimestamp("dateFrom", datefrom).setTimestamp("dateTo", dateto).list();
		return facturas.stream().mapToDouble(f -> f.getMonto()).sum();
    }	
    
    public RegistroCaja getByDate(Date date,int sucursalId) {
    	List<RegistroCaja> registroCaja = getHibernateTemplate().createQuery("select RC from RegistroCaja RC where date = :date and RC.sucursal.sucursalId  = :sucursalId")
    			.setTimestamp("date",date).setInteger("sucursalId", sucursalId).list();
    	if(registroCaja.isEmpty()) {
    		return null;
    	}
    	return registroCaja.get(0);
    }
}
