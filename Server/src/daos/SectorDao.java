package daos;

import java.util.List;

import dominio.Sector;
import hbt.GenericDao;

public class SectorDao extends GenericDao<Sector> {
	
	private static SectorDao dao;

    public static SectorDao getDao(){
        if(dao == null){
            dao = new SectorDao();
        }
        return dao;
    }
}
