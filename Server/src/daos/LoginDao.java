package daos;

import dominio.Login;
import hbt.GenericDao;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;

public class LoginDao extends GenericDao<Login>{
	private static LoginDao dao;

    public static LoginDao getDao(){
        if(dao == null){
            dao = new LoginDao();
        }
        return dao;
    }

    public Login obtenerLogin(Login l){
        Login returnValue = (Login) getHibernateTemplate().createQuery("select L from Login L where L.usuarioLogin = :usuarioLogin and L.password = :password").setString("usuarioLogin", l.getUsuarioLogin()).setString("password", l.getPassword()).setFirstResult(0).setMaxResults(1).uniqueResult();
        return returnValue;
    }

}
