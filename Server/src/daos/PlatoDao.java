package daos;

import dominio.Plato;
import hbt.GenericDao;

public class PlatoDao extends GenericDao<Plato>{
	
	private static PlatoDao dao;

    public static PlatoDao getDao(){
        if(dao == null){
            dao = new PlatoDao();
        }
        return dao;
    }
}
