package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import remoto.ITestService;
import dominio.*;
import daos.TestDao;
import dto.TestDto;


public class TestService extends UnicastRemoteObject implements ITestService  {
	public TestService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void envioTest(TestDto test) throws RemoteException{
		TestDao testdao = new TestDao();
		System.out.println("test");
		testdao.Guardar(new Test(test.getTest()));
	}

}