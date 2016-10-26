package app;

public class IniciarServidor {
    
	public static void main(String[] args) {
		System.setProperty("java.security.policy","C:\\Projects\\AD\\security\\rmi.policy");
		if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
		new BS().publicarServicio();
	}
}
