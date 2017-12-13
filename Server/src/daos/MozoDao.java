package daos;

import java.util.List;

import dominio.Mozo;
import hbt.GenericDao;

public class MozoDao extends GenericDao<Mozo>{
	
	 private static MozoDao dao;

	    public static MozoDao getDao(){
	        if(dao == null){
	            dao = new MozoDao();
	        }
	        return dao;
	    }

	@SuppressWarnings("unchecked")
	public List<Mozo> obtenerMozosSucursal(int sucursal_id){		
		List<Mozo> lista = getHibernateTemplate().createQuery("select M from Sucursal S join S.sectores SS join SS.mozoAsociado M where S.sucursalId = :sucursal_id").setInteger("sucursal_id", sucursal_id).list();
		return lista;
	}
	
}
