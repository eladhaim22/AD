package daos;

import java.util.List;

import dominio.PlanDeProduccion;
import hbt.GenericDao;

public class PlanDeProduccionDao extends GenericDao<PlanDeProduccion> {

	private static PlanDeProduccionDao dao;

    public static PlanDeProduccionDao getDao(){
        if(dao == null){
            dao = new PlanDeProduccionDao();
        }
        return dao;
    }
    
	public List<PlanDeProduccion> obtenerPorSucursal(Integer sucursalId)
	{
		List<PlanDeProduccion> list = getHibernateTemplate().createQuery("from PlanDeProduccion pp where pp.sucursalId : sucirsalId ")
				.setInteger("sucursalId", sucursalId)
				.list();
		return list;
	}
}
