package daos;

import dominio.Deposito;
import hbt.GenericDao;

public class DepositoDao extends GenericDao<Deposito> {

	private static DepositoDao dao;

    public static DepositoDao getDao(){
        if(dao == null){
            dao = new DepositoDao();
        }
        return dao;
    }
}
