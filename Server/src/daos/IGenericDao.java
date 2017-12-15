package daos;

import org.hibernate.HibernateException;

import java.util.List;

public interface IGenericDao<Entidad> {

    Entidad buscar(int index);

    void Actualizar(Entidad t);

    void Guardar(Entidad t) throws HibernateException;

    void Eliminar(Entidad t);

    List<Entidad> ListarTodos() throws HibernateException;
}