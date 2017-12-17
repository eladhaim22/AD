package hbt;

import model.ItemIngrediente;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import entities.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.addAnnotatedClass(AreaEntity.class);
            config.addAnnotatedClass(BarraEntity.class);
            config.addAnnotatedClass(CafeteriaEntity.class);
            config.addAnnotatedClass(CartaEntity.class);
            config.addAnnotatedClass(CocinaEntity.class);
            config.addAnnotatedClass(FacturaEntity.class);
            config.addAnnotatedClass(IngredienteEntity.class);
            config.addAnnotatedClass(ItemCartaEntity.class);
            config.addAnnotatedClass(ItemFacturaEntity.class);
            config.addAnnotatedClass(ComandaEntity.class);
            config.addAnnotatedClass(ItemPPEntity.class);
            config.addAnnotatedClass(ItemRemitoEntity.class);
            config.addAnnotatedClass(LiquidacionEntity.class);
            config.addAnnotatedClass(MarcaEntity.class);
            config.addAnnotatedClass(MesaEntity.class);
            config.addAnnotatedClass(MozoEntity.class);
            config.addAnnotatedClass(PedidoEntity.class);
            config.addAnnotatedClass(PlanDeProduccionEntity.class);
            config.addAnnotatedClass(PlatoEntity.class);
            config.addAnnotatedClass(ItemIngredienteEntity.class);
            config.addAnnotatedClass(PresentacionEntity.class);
            config.addAnnotatedClass(RegistroCajaEntity.class);
            config.addAnnotatedClass(RemitoEntity.class);
            config.addAnnotatedClass(SectorEntity.class);
            config.addAnnotatedClass(SemielaboradoEntity.class);
            config.addAnnotatedClass(StockEntity.class);
            config.addAnnotatedClass(SucursalEntity.class);
            sessionFactory = config.buildSessionFactory();
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
