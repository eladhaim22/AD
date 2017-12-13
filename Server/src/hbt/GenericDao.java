package hbt;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.*;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDao<Entidad> implements IGenericDao<Entidad> {

    protected Class<Entidad> domainClass = getDomainClass();

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }
    
    protected Session getHibernateTemplate() {
    	return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Entidad Buscar(int index) {
        Entidad returnValue = (Entidad)getHibernateTemplate().get(domainClass,index);
        if(returnValue != null){
            Hibernate.initialize(returnValue);
            return returnValue;
        }else{
            return null;
        }
    }

    public void Actualizar(Entidad t) throws HibernateException {
        try {
            getHibernateTemplate().update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Guardar(Entidad t) throws HibernateException {
        try {
            getHibernateTemplate().save(t);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Eliminar(Entidad t) {
        getHibernateTemplate().delete(t);
    }

    public List<Entidad> ListarTodos() throws HibernateException {
        List objects = null;
        try {
            Query query = getHibernateTemplate().createQuery("from " + domainClass.getName());
            objects = query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }

        finally {
            return objects;
        }
    }
}