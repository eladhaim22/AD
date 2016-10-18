package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import Model.*;
public class HibernateUtil {


    private static final SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static
    {
        try
        {
            Configuration config = new Configuration();
            config.addAnnotatedClass(Pedido.class);

            config.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);

        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}
