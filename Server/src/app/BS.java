package app;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import controller.AdminstracionService;
import daos.MesaDao;
import dominio.Mesa;
import remoto.IAdminstracionService;

public class BS {
    
    public void publicarServicio() {
    	try {
    		IAdminstracionService administracionService = new AdminstracionService();
    		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Naming.rebind("//localhost/administracion", administracionService);
			System.out.println("Remote Server Running");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
