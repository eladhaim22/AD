package daos;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import entities.FacturaEntity;
import entities.MesaEntity;
import entities.RegistroCajaEntity;
import hbt.GenericDao;
import model.RegistroCaja;

public class RegistroCajaDao extends GenericDao<RegistroCaja,RegistroCajaEntity>{

	private static RegistroCajaDao dao;

    public static RegistroCajaDao getDao(){
        if(dao == null){
            dao = new RegistroCajaDao();
        }
        return dao;
    }
	
    public double calcualrValorCajaEsperado(List<MesaEntity> mesas) {
    	Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date datefrom = Date.from(instant);
		instant = Instant.now().plusSeconds(86400);
		instant = instant.truncatedTo(ChronoUnit.DAYS);
		Date dateto = Date.from(instant);
		List<FacturaEntity> facturas = getHibernateTemplate().createQuery("select F from Pedido P join P.factura F where P.FechaCierre >= :dateFrom and P.FechaCierre < :dateTo and P.mesaAsociada in (:mesas)")
				.setParameterList("mesas", mesas).setTimestamp("dateFrom", datefrom).setTimestamp("dateTo", dateto).list();
		return facturas.stream().mapToDouble(f -> f.getMonto()).sum();
    }	
    
    public RegistroCajaEntity getByDate(Date date, int sucursalId) {
    	List<RegistroCajaEntity> registroCaja = getHibernateTemplate().createQuery("select RC from RegistroCaja RC where date = :date and RC.sucursal.sucursalId  = :sucursalId")
    			.setTimestamp("date",date).setInteger("sucursalId", sucursalId).list();
    	if(registroCaja.isEmpty()) {
    		return null;
    	}
    	return registroCaja.get(0);
    }

	@Override
	public RegistroCajaEntity toEntity(RegistroCaja registroCaja) {
		return new RegistroCajaEntity(registroCaja.getId(),
				SucursalDao.getDao().toEntity(registroCaja.getSucursal()),registroCaja.getDate(),
				registroCaja.getValorCaja(),registroCaja.getValorEsperado());
	}

	@Override
	public RegistroCaja toNegocio(RegistroCajaEntity registroCajaEntity) {
		return new RegistroCaja(registroCajaEntity.getId(),
				SucursalDao.getDao().toNegocio(registroCajaEntity.getSucursal()),registroCajaEntity					.getDate(), registroCajaEntity.getValorCaja(),registroCajaEntity.getValorEsperado());
	}
}
