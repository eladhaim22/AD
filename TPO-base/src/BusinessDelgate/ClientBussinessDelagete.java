package BusinessDelgate;

import Exceptions.CustomServiceException;
import dto.TestDto;
import remoto.ITestService;
import sun.plugin2.message.CustomSecurityManagerAckMessage;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClientBussinessDelagete {
    private ITestService testService;
    private static ClientBussinessDelagete clientBussinessDelagate = null;

    private ClientBussinessDelagete(){}

    public static ClientBussinessDelagete getClientBussinessDelagate() {
       if(clientBussinessDelagate == null) {
           clientBussinessDelagate = new ClientBussinessDelagete();
       }
       return clientBussinessDelagate;
    }

    private boolean getStub() {
        try {
            System.setProperty("java.security.policy","C:\\Projects\\AD\\security\\rmi.policy");
            if(System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            testService = (ITestService) Naming.lookup ("//localhost/Test");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void envioTest(TestDto test) throws CustomServiceException{
        if(getStub())
        {
            try {
                testService.envioTest(test);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
