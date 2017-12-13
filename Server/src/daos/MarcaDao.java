package daos;

import dominio.Marca;
import hbt.GenericDao;

public class MarcaDao extends GenericDao<Marca> {
	
	private static MarcaDao dao;

    public static MarcaDao getDao(){
        if(dao == null){
            dao = new MarcaDao();
        }
        return dao;
    }
}
