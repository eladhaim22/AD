package daos;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


import entities.RegistroCajaEntity;
import hbt.HibernateUtil;
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
		Date truncatedDate = Date.from(date.toInstant().truncatedTo(ChronoUnit.DAYS));
		RegistroCajaEntity registroCajaE = (RegistroCajaEntity) session.createQuery("select RC from RegistroCajaEntity RC where date = :date and RC.sucursal.sucursalId  = :sucursalId")
    			.setTimestamp("date",truncatedDate).setInteger("sucursalId", sucursalId).uniqueResult();
		registroCaja = this.toNegocio(registroCajaE);
		session.close();
    	return registroCaja;
    }

	@Override
	public RegistroCajaEntity toEntity(RegistroCaja registroCaja) {
		return registroCaja == null ? null : new RegistroCajaEntity(registroCaja.getId(),
				SucursalDao.getDao().toEntity(registroCaja.getSucursal()),registroCaja.getDate(),
				registroCaja.getValorCaja(),registroCaja.getValorEsperado());
	}

	@Override
	public RegistroCaja toNegocio(RegistroCajaEntity registroCajaEntity) {
		return registroCajaEntity == null ? null : new RegistroCaja(registroCajaEntity.getId(),
				SucursalDao.getDao().toNegocio(registroCajaEntity.getSucursal()),registroCajaEntity					.getDate(), registroCajaEntity.getValorCaja(),registroCajaEntity.getValorEsperado());
	}
}
