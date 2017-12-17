package daos;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import entities.FacturaEntity;
import entities.MesaEntity;
import entities.RegistroCajaEntity;
import hbt.HibernateUtil;
import model.Factura;
import model.RegistroCaja;
import org.hibernate.Session;

public class RegistroCajaDao extends GenericDao<RegistroCaja,RegistroCajaEntity>{

	private static RegistroCajaDao dao;

    public static RegistroCajaDao getDao() {
		if (dao == null) {
			dao = new RegistroCajaDao();
		}
		return dao;
	}
    
    public RegistroCaja getByDate(Date date, int sucursalId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
    	RegistroCaja registroCaja = null;
		List<RegistroCajaEntity> registroCajaE = session.createQuery("select RC from RegistroCajaEntity RC where date = :date and RC.sucursal.sucursalId  = :sucursalId")
    			.setTimestamp("date",date).setInteger("sucursalId", sucursalId).list();
    	if(!registroCajaE.isEmpty()) {
    		registroCaja = this.toNegocio(registroCajaE.get(0));
		}
		session.close();
    	return registroCaja;
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
