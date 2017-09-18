package Cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;

import BusinessDelgate.ClientBussinessDelagete;
import Exceptions.CustomServiceException;
import dto.TestDto;
import remoto.ITestService;

public class cliente {

	public static void main(String[] args)
	{
		try {
			ClientBussinessDelagete.getClientBussinessDelagate().envioTest(new TestDto("asdfasdfs"));
		} catch (CustomServiceException e) {
			e.printStackTrace();
		}
	}
}
