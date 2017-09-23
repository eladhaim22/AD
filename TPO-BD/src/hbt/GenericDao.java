package hbt;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.*;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDao<Entidad> implements IGenericDao<Entidad> {

    protected Class<Entidad> domainClass = getDomainClass();

    private Session session;

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    protected Session getHibernateTemplate() {
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	session.beginTransaction();
        }
        catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
        return session;
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
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Guardar(Entidad t) throws HibernateException {
        try {
            getHibernateTemplate().save(t);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Eliminar(Entidad t) {
        getHibernateTemplate().delete(t);
        session.getTransaction().commit();
    }

    public List<Entidad> ListarTodos() throws HibernateException {
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