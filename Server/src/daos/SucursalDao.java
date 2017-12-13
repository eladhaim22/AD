package daos;

import java.util.List;

import dominio.Sucursal;
import hbt.GenericDao;

public class SucursalDao extends GenericDao<Sucursal> {

	private static SucursalDao dao;

    public static SucursalDao getDao(){
        if(dao == null){
            dao = new SucursalDao();
        }
        return dao;
    }
	
	public void grabarTodas(List<Sucursal> objetoNuevo){
		for(Sucursal s : objetoNuevo){
			getHibernateTemplate().saveOrUpdate(s);
		}		
		
	}
}
