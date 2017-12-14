package daos;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import entities.LiquidacionEntity;
import hbt.GenericDao;
import model.Liquidacion;

public class LiquidacionDao extends GenericDao<Liquidacion,LiquidacionEntity>{

	private static LiquidacionDao dao;

    public static LiquidacionDao getDao(){
        if(dao == null){
            dao = new LiquidacionDao();
        }
        return dao;
    }
    
    public LiquidacionEntity obtenerLiquidacionDeLaFecha(int mozo) {
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date date = Date.from(instant);
		List<LiquidacionEntity> liquidacions = getHibernateTemplate().createQuery("select L from Liquidacion L where L.fecha = :date and L.mozo.id = :mozoId")
			.setInteger("mozoId",mozo).setTimestamp("date", date).list();
        if(liquidacions.isEmpty()) {
        	return null;
        }
        	return liquidacions.get(0);
    }

    @Override
    public LiquidacionEntity toEntity(Liquidacion liquidacion) {
        return new LiquidacionEntity(liquidacion.getId(),
                MozoDao.getDao().toEntity(liquidacion.getUsuario()),liquidacion.getFecha(),liquidacion.getValue());
    }

    @Override
    public Liquidacion toNegocio(LiquidacionEntity liquidacionEntity) {
        return new Liquidacion(liquidacionEntity.getId(),
                MozoDao.getDao().toNegocio(liquidacionEntity.getUsuario()),liquidacionEntity.getFecha(),     liquidacionEntity.getValue());
    }
}
