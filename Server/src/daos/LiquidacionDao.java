package daos;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import entities.LiquidacionEntity;
import hbt.HibernateUtil;
import model.Liquidacion;
import org.hibernate.Session;

public class LiquidacionDao extends GenericDao<Liquidacion,LiquidacionEntity>{

	private static LiquidacionDao dao;

    public static LiquidacionDao getDao(){
        if(dao == null){
            dao = new LiquidacionDao();
        }
        return dao;
    }
    
    public Liquidacion obtenerLiquidacionDeLaFecha(int mozo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date date = Date.from(instant);
		List<LiquidacionEntity> liquidacions = session.createQuery("select L from LiquidacionEntity L where L.fecha = :date and L.mozo.id = :mozoId")
			.setInteger("mozoId",mozo).setTimestamp("date", date).list();
		Liquidacion liquidacion = null;
		if(!liquidacions.isEmpty()) {
        	liquidacion = this.toNegocio(liquidacions.get(0));
        }
        return liquidacion;
    }

    @Override
    public LiquidacionEntity toEntity(Liquidacion liquidacion) {
        return liquidacion == null ? null : new LiquidacionEntity(liquidacion.getId(),
                MozoDao.getDao().toEntity(liquidacion.getUsuario()),liquidacion.getFecha(),liquidacion.getValue());
    }

    @Override
    public Liquidacion toNegocio(LiquidacionEntity liquidacionEntity) {
        return liquidacionEntity == null ? null : new Liquidacion(liquidacionEntity.getId(),
                MozoDao.getDao().toNegocio(liquidacionEntity.getUsuario()),liquidacionEntity.getFecha(),     liquidacionEntity.getValue());
    }
}
