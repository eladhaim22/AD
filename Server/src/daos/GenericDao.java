package daos;
import hbt.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<Negocio,Entity>{

    protected Class<Entity> entityClass = getEntityClass();

    protected Class getEntityClass() {
        if (entityClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            entityClass = (Class) thisType.getActualTypeArguments()[1];
        }
        return entityClass;
    }


    public Negocio buscar(int index) {
        Negocio resultado = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Entity entity = (Entity) session.get(entityClass,index);
        resultado = this.toNegocio(entity);
        session.close();
        return resultado;
    }


    public List<Negocio> ListarTodos() throws HibernateException {
        List<Negocio> resultado = new ArrayList<Negocio>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Entity> entities = (List<Entity>)session.createQuery("from " + entityClass.getName())          .list();
        for(Entity entity : entities)
            resultado.add(this.toNegocio(entity));
        session.close();
        return resultado;
    }

    public Integer save(Negocio negocio){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(this.toEntity(negocio));
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public void update(Negocio negocio){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(this.toEntity(negocio));
        session.getTransaction().commit();
        session.close();
    }

    public abstract Entity toEntity(Negocio negocio);

    public abstract Negocio toNegocio(Entity entity);

}