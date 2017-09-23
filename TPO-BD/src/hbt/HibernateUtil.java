package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import dominio.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.addAnnotatedClass(Address.class);
            config.addAnnotatedClass(Administracion.class);
            config.addAnnotatedClass(Area.class);
            config.addAnnotatedClass(AsientoContable.class);
            config.addAnnotatedClass(Caja.class);
            config.addAnnotatedClass(Carta.class);
            config.addAnnotatedClass(Cocina.class);
            config.addAnnotatedClass(Comanda.class);
            config.addAnnotatedClass(Deposito.class);
            config.addAnnotatedClass(DepositoCentral.class);
            config.addAnnotatedClass(DepositoLocal.class);
            config.addAnnotatedClass(Factura.class);
            config.addAnnotatedClass(Item.class);
            config.addAnnotatedClass(ItemCarta.class);
            config.addAnnotatedClass(ItemComanda.class);
            config.addAnnotatedClass(ItemComplejo.class);
            config.addAnnotatedClass(ItemFactura.class);
            config.addAnnotatedClass(ItemOrdenCompra.class);
            config.addAnnotatedClass(ItemPlanProduccion.class);
            config.addAnnotatedClass(ItemReceta.class);
            config.addAnnotatedClass(MedioPago.class);
            config.addAnnotatedClass(Mesa.class);
            config.addAnnotatedClass(Mozo.class);
            config.addAnnotatedClass(OrdenCompra.class);
            config.addAnnotatedClass(Pedido.class);
            config.addAnnotatedClass(PlanProduccion.class);
            config.addAnnotatedClass(ProductosEstimados.class);
            config.addAnnotatedClass(Proveedor.class);
            config.addAnnotatedClass(Receta.class);
            config.addAnnotatedClass(Reserva.class);
            config.addAnnotatedClass(Salon.class);
            config.addAnnotatedClass(Sector.class);
            config.addAnnotatedClass(Stock.class);
            config.addAnnotatedClass(Sucursal.class);
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
