package BusinessDelgate;

import Exceptions.CustomServiceException;

import dto.MesaDto;
import remoto.IAdminstracionService;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class AdministracionBussinessDelagete {
    private IAdminstracionService administracionService;
    private static AdministracionBussinessDelagete administracionBussinessDelagete = null;

    private AdministracionBussinessDelagete(){}

    public static AdministracionBussinessDelagete getAdministracionBussinessDelagete() {
       if(administracionBussinessDelagete == null) {
           administracionBussinessDelagete = new AdministracionBussinessDelagete();
       }
       return administracionBussinessDelagete;
    }

    private boolean getStub() {
        try {
            System.setProperty("java.security.policy","C:\\Projects\\AD\\security\\rmi.policy");
            if(System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            administracionService = (IAdminstracionService) Naming.lookup ("//localhost/Administracion");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<MesaDto> AbrirMesa(int cantPersonas) throws CustomServiceException{
        List<MesaDto> mesas = new ArrayList<MesaDto>();
        if(getStub())
        {
            try {
                mesas = administracionService.obtenerMesa(cantPersonas);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return mesas;
    }

}
