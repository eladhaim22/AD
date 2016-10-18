package  Hibernate;


import org.hibernate.HibernateException;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<Entity, K extends Serializable> {

    Entity Buscar(K id);

    void Actualizar(Entity t);

    void Guardar(Entity t) throws HibernateException;

    void Eliminar(Entity t);

    List<Entity> ListarTodos() throws HibernateException;
}
