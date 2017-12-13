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
            config.addAnnotatedClass(Area.class);
            config.addAnnotatedClass(Cajero.class);
            config.addAnnotatedClass(Carta.class);
            config.addAnnotatedClass(Deposito.class);
            config.addAnnotatedClass(Factura.class);
            config.addAnnotatedClass(Ingrediente_Semielaborado.class);
            config.addAnnotatedClass(IngredienteProducto.class);
            config.addAnnotatedClass(ItemCarta.class);
            config.addAnnotatedClass(ItemDeposito.class);
            config.addAnnotatedClass(ItemPedido.class);
            config.addAnnotatedClass(ItemPP.class);
            config.addAnnotatedClass(Login.class);
            config.addAnnotatedClass(Lote.class);
            config.addAnnotatedClass(LoteProducto.class);
            config.addAnnotatedClass(LoteSemielaborado.class);
            config.addAnnotatedClass(Marca.class);
            config.addAnnotatedClass(Mesa.class);
            config.addAnnotatedClass(Mozo.class);
            config.addAnnotatedClass(Pedido.class);
            config.addAnnotatedClass(PlanDeProduccion.class);
            config.addAnnotatedClass(Plato.class);
            config.addAnnotatedClass(Presentacion.class);
            config.addAnnotatedClass(Producto.class);
            config.addAnnotatedClass(Proveedor.class);
            config.addAnnotatedClass(Semielaborado.class);
            config.addAnnotatedClass(Sector.class);
            config.addAnnotatedClass(Sucursal.class);
            config.addAnnotatedClass(Usuario.class);
            config.addAnnotatedClass(RegistroCaja.class);
            config.addAnnotatedClass(Liquidacion.class);
            config.addAnnotatedClass(Remito.class);
            config.addAnnotatedClass(ItemRemito.class);
            config.addAnnotatedClass(Deposito.class);
            config.addAnnotatedClass(Stock.class);
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
