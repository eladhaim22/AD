package Server;
import Model.Pedido;
import Services.PedidoService;

public class IniciarServidor {

    public static void main(String[] args) {
        /*System.setProperty("java.security.policy", "java.policy");
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/

        PedidoService pedidoService = new PedidoService();
        Pedido p = new Pedido();
        p = pedidoService.Buscar(1);
        System.out.println("dsasf");
    }
}
