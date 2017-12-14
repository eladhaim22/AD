package hbt;
import com.sun.org.apache.xpath.internal.operations.Neg;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<Negocio,Entity> implements IGenericDao<Negocio> {

    protected Class<Entity> entityClass = getEntityClass();

    protected Class getEntityClass() {
        if (entityClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            entityClass = (Class) thisType.getActualTypeArguments()[1];
        }
        return entityClass;
    }
    
    protected Session getHibernateTemplate() {
    	return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Negocio buscar(int index) {
        Negocio resultado = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Entity entity = (Entity) session.get(entityClass,index);
        resultado = this.toNegocio(entity);
        session.close();
        return resultado;
    }

    public void Actualizar(Negocio t) throws HibernateException {
        try {
            getHibernateTemplate().update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Guardar(Negocio t) throws HibernateException {
        try {
            getHibernateTemplate().save(t);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public void Eliminar(Negocio t) {
        getHibernateTemplate().delete(t);
    }

    public List<Negocio> ListarTodos() throws HibernateException {
        List<Negocio> resultado = new ArrayList<Negocio>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Entity> entities = (List<Entity>)session.createQuery("from " + entityClass.getName())          .list();
        for(Entity entity : entities)
            resultado.add(this.toNegocio(entity));
        session.close();
        return resultado;
    }

    public void save(Negocio negocio){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(this.toEntity(negocio));
        session.getTransaction().commit();
        session.close();
    }

    public abstract Entity toEntity(Negocio negocio);

    public abstract Negocio toNegocio(Entity entity);

}