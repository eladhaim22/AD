package daos;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import dominio.Liquidacion;
import dominio.Pedido;
import hbt.GenericDao;

public class LiquidacionDao extends GenericDao<Liquidacion>{

	private static LiquidacionDao dao;

    public static LiquidacionDao getDao(){
        if(dao == null){
            dao = new LiquidacionDao();
        }
        return dao;
    }
    
    public Liquidacion obtenerLiquidacionDeLaFecha(int usuarioId) {
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date date = Date.from(instant);
		List<Liquidacion> liquidacions = getHibernateTemplate().createQuery("select L from Liquidacion L where L.fecha = :date and L.usuario.nroUsuario = :usuarioId")
			.setInteger("usuarioId",usuarioId).setTimestamp("date", date).list();
        if(liquidacions.isEmpty()) {
        	return null;
        }
        	return liquidacions.get(0);
    }
}
