package daos;

import java.util.List;

import dominio.Semielaborado;
import hbt.GenericDao;

public class SemielaboradoDao extends GenericDao<Semielaborado>{

	private static SemielaboradoDao dao;

    public static SemielaboradoDao getDao(){
        if(dao == null){
            dao = new SemielaboradoDao();
        }
        return dao;
    }
}
