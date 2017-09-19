package daos;

import dominio.Mesa;
import hbt.GenericDao;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;

public class MesaDao extends GenericDao<Mesa> {
    private static MesaDao dao;

    public static MesaDao getDao(){
        if(dao == null){
            dao = new MesaDao();
        }
        return dao;
    }

    public List<Mesa> ListarMesasDisponibles(){
        List<Mesa> returnValue = getHibernateTemplate().createQuery("from Mesa where isEmpty = true").list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
}
