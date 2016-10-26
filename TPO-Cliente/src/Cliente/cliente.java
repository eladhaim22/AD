package Cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;

import dto.TestDto;
import remoto.ITestService;

public class cliente {
    
	ITestService test;

	
	public static void main(String[] args)
	{
		new cliente();
	}
	
    public boolean getStub() {
    	
    	try {
    		System.setProperty("java.security.policy","C:\\Projects\\AD\\security\\rmi.policy");
    		if(System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
			test = (ITestService)Naming.lookup ("//localhost/Test");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public cliente(){
    	if(getStub()) 
    	{
    		try {
    			test.envioTest(new TestDto("asdfasdf"));
    		} catch (RemoteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	} 
    }

}