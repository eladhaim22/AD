package app;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remoto.ITestService;
import service.TestService;

public class BS {
    
    public void publicarServicio() {
    	try {
    		ITestService cons = new TestService();
    		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Naming.rebind("//localhost/Test", cons);
			System.out.println("Remote Server Running");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
