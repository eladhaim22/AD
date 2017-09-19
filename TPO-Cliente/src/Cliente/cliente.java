package Cliente;

import BusinessDelgate.AdministracionBussinessDelagete;
import Exceptions.CustomServiceException;


public class cliente {

	public static void main(String[] args)
	{
		try {
			AdministracionBussinessDelagete.getAdministracionBussinessDelagete().AbrirMesa(4);
		} catch (CustomServiceException e) {
			e.printStackTrace();
		}
	}
}
