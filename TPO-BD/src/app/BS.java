package app;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remoto.IAdminstracionService;
import service.AdminstracionService;

public class BS {
    
    public void publicarServicio() {
    	try {
    		IAdminstracionService cons = new AdminstracionService();
    		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Naming.rebind("//localhost/Administracion", cons);
			System.out.println("Remote Server Running");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
