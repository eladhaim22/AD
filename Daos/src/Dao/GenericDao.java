package Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import Hibernate.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public class GenericDao<Entity, K extends Serializable> implements IGenericDao<Entity, K> {

    public Class<Entity> domainClass = getDomainClass();
    private Session session;

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private Session getHibernateTemplate() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    public Entity Buscar(K id) {
        Entity returnValue = (Entity) getHibernateTemplate().load(domainClass, id);
        session.getTransaction().commit();
        return returnValue;
    }

    public void Actualizar(Entity t) throws HibernateException {
        try {
            getHibernateTemplate().update(t);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Guardar(Entity t) throws HibernateException {
        try {
            getHibernateTemplate().save(t);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Eliminar(Entity t) {
        getHibernateTemplate().delete(t);
        session.getTransaction().commit();
    }

    public List<Entity> ListarTodos() throws HibernateException {
        List objects = null;
        try {
            getHibernateTemplate();
            Query query = session.createQuery("from " + domainClass.getName());
            objects = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }

        finally {
            return objects;
        }
    }
}