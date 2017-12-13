package daos;

import dominio.Producto;
import hbt.GenericDao;

public class ProductoDao extends GenericDao<Producto>{

	private static ProductoDao dao;

    public static ProductoDao getDao(){
        if(dao == null){
            dao = new ProductoDao();
        }
        return dao;
    }	
}
