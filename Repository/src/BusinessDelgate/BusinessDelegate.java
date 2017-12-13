package BusinessDelgate;

import dto.CartaDto;
import dto.FacturaDto;
import dto.ItemCartaDto;
import dto.ItemPedidoDto;
import dto.LoginDto;
import dto.MesaDto;
import dto.MozoDto;
import dto.PedidoDto;
import dto.SectorDto;
import dto.SucursalDto;
import remoto.IAdminstracionService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import Exceptions.ServiceError;

public class BusinessDelegate {
    private IAdminstracionService administracionService;
    private static BusinessDelegate administracionBussinessDelagete = null;

    private BusinessDelegate(){}

    public static BusinessDelegate getInstance() {
       if(administracionBussinessDelagete == null) {
           administracionBussinessDelagete = new BusinessDelegate();
       }
       return administracionBussinessDelagete;
    }

    private void getStub() throws ServiceError {
            try {
				administracionService = (IAdminstracionService) Naming.lookup ("//localhost/administracion");
			} catch (MalformedURLException e) {
				throw new ServiceError("ruta mal formada",e.getMessage());
			} catch (RemoteException e) {
				throw new ServiceError(e.getMessage());
			} catch (NotBoundException e) {
				throw new ServiceError("no se encuentra este servicio",e.getMessage());
			} catch (Exception e) {
				throw new ServiceError(e.getMessage());
			}
       
    }
    
    public List<SectorDto> obtenerSectores() throws ServiceError{
    	try {
    		getStub();
    		return administracionService.obtenerSectores();
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
    }
    
    public List<SucursalDto> obtenerSucursales() throws ServiceError{
    	try {
    		getStub();
			return administracionService.obtenerSucursales();
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
    }
    
    public Boolean autenticarUsuario(LoginDto login) throws ServiceError {
		try {
			getStub();
			return administracionService.autenticarUsuario(login);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
    
    public List<MozoDto> obtenerMozos(int sucursalId) throws ServiceError{
		try {
			getStub();
			return administracionService.obtenerMozos(sucursalId);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
    }

    public List<MesaDto> obtenerMesas(int sucursal_id, int mozoId, int CantComensales) throws ServiceError{
        try {
            return administracionService.obtenerMesas(sucursal_id, mozoId, CantComensales);
        } catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
    }
    
    public PedidoDto confirmarAperturaMesa(int mesaId, int CantComensales,int mozoId) throws ServiceError{
    	try {
			return administracionService.confirmarAperturaMesa(mesaId,CantComensales,mozoId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
    }

	public List<MesaDto> obtenerMesasAbiertaPorSucursal(int sucursalId) throws  ServiceError{
    	try{
    		return administracionService.obtenerMesasAbiertaPorSucursal(sucursalId);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
        
	public List<MesaDto> getMesasImpagas(int sucursalId, int mozoId)throws ServiceError{
		try {
			return administracionService.getMesasImpagas(sucursalId, mozoId);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public FacturaDto getDatosFactura(int mesaId)throws ServiceError{
		try {
			return administracionService.getDatosFactura(mesaId);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId)throws ServiceError{
		try {
			administracionService.registrarPagoFactura(facturaId, medioPago, mesaId);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}

	public List<CartaDto> obtenerCartasPorSucursal(int sucursalId) throws ServiceError {
    	try{
    		return administracionService.obtenerCartasPorSucursal(sucursalId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public PedidoDto obtenerPedidoPorMesa(int mesaId) throws ServiceError
	{
    	try{
    		return administracionService.obtenerPedidoPorMesa(mesaId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public List<ItemCartaDto> obtenerItemCarta(int cartaId) throws ServiceError
	{
    	try{
    		return administracionService.obtenerItemCarta(cartaId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}

	public void agregarItemPedido(int pedidoId, List<ItemPedidoDto> listItems) throws  ServiceError {
    	try{
    		administracionService.agregarItemPedido(pedidoId,listItems);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}

	public PedidoDto obtenerPedido(int pedidoId) throws ServiceError {
    	try{
    		return administracionService.obtenerPedido(pedidoId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}

	public ItemCartaDto obtenerItemCartaById(int id) throws ServiceError {
    	try{
    		return administracionService.obtenerItemCartaById(id);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}

	public void cerrarMesa(int mesaId) throws ServiceError{
    	try{
    		administracionService.cerrarMesa(mesaId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}			
	}

	public void generarFactura(int mesaId) throws ServiceError{
    	try{
    		administracionService.generarFactura(mesaId);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public List<MesaDto> obtenerMesasDisponibles(int sucursal_id,int mozoId,int cantComensales) throws ServiceError
	{
		try{
    		return administracionService.obtenerMesasDisponibles(sucursal_id, mozoId, cantComensales);
    	} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public Map<String,Double> calcularComissionEnSucursal(int sucursalId) throws ServiceError {
		try{
    		return administracionService.calcularComissionEnSucursal(sucursalId);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public Double cerrarCaja(int sucursalId,double dineroEnCaja) throws ServiceError{
		try{
			return administracionService.cerrarCaja(sucursalId, dineroEnCaja);
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}
	
	public void generarRemito() throws ServiceError{
		try{
			administracionService.generarRemito();
		} catch (RemoteException e) {
			throw new ServiceError(e.getMessage());
		}	
	}

}
