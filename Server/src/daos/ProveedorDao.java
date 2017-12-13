package daos;

import dominio.Proveedor;
import hbt.GenericDao;

public class ProveedorDao extends GenericDao<ProveedorDao> {
	
	private static ProveedorDao dao;

    public static ProveedorDao getDao(){
        if(dao == null){
            dao = new ProveedorDao();
        }
        return dao;
    }	
}
