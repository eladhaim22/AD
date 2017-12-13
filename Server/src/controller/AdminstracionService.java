package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

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
import service.CajaService;
import service.CartaService;
import service.DepositoService;
import service.FacturaService;
import service.MesaService;
import service.MozoService;
import service.PedidoService;
import service.SectorService;
import service.SucursalService;
import service.UsuarioService;

public class AdminstracionService extends UnicastRemoteObject implements IAdminstracionService {

	
	public AdminstracionService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void cargarDatosIniciales() throws RemoteException {

	}
	public ItemCartaDto obtenerItemCartaById(int id) throws RemoteException {
		return CartaService.getInstance().obtenerItemCartaById(id);
	}

	public List<ItemCartaDto> obtenerItemCarta(int cartaId) throws RemoteException {
		return CartaService.getInstance().obtenerItemCarta(cartaId);
	}

	public List<CartaDto> obtenerCartasPorSucursal(int sucursalId) throws RemoteException {
		return CartaService.getInstance().obtenerCartasPorSucursal(sucursalId);
	}

	public void generarFactura(int mesaId) throws RemoteException {
		FacturaService.getInstance().generarFactura(mesaId);
	}

	public void cerrarMesa(int mesaId) throws RemoteException {
		MesaService.getInstance().cerrarMesa(mesaId);
	}

	public List<MesaDto> obtenerMesasAbiertaPorSucursal(int sucursalId) throws RemoteException {
		return SucursalService.getInstance().obtenerMesasAbiertaPorSucursal(sucursalId);
	}

	public List<MesaDto> obtenerMesasDisponibles(int sucursal_id, int mozoId, int cantComensales)
			throws RemoteException {
		return MesaService.getInstance().obtenerMesasDisponibles(sucursal_id, mozoId, cantComensales);
	}

	public PedidoDto obtenerPedidoPorMesa(int mesaId) throws RemoteException {
		return PedidoService.getInstance().obtenerPedidoPorMesa(mesaId);
	}

	public void agregarItemPedido(int pedidoId, List<ItemPedidoDto> listItems) throws RemoteException {
		PedidoService.getInstance().agregarItemPedido(pedidoId, listItems);
	}

	public PedidoDto obtenerPedido(int pedidoId) throws RemoteException{
		return PedidoService.getInstance().obtenerPedido(pedidoId);
	}

	public List<SectorDto> obtenerSectores() throws RemoteException{
		return SectorService.getInstance().obtenerSectores();
	}

	public List<SucursalDto> obtenerSucursales() throws RemoteException{
		return SucursalService.getInstance().obtenerSucursales();
	}

	public List<MozoDto> obtenerMozos(int sucursal_id) throws RemoteException{
		return SucursalService.getInstance().obtenerMozos(sucursal_id);
	}
	
	public List<MesaDto> getMesasImpagas(int sucursalId, int mozoId) throws RemoteException{
		return SucursalService.getInstance().getMesasImpagas(sucursalId, mozoId);
	}

	public FacturaDto getDatosFactura(int mesaId) throws RemoteException{
		return SucursalService.getInstance().getDatosFactura(mesaId);
	}

	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId) throws RemoteException{
		SucursalService.getInstance().registrarPagoFactura(facturaId, medioPago, mesaId);
	}

	public Boolean autenticarUsuario(LoginDto login) throws RemoteException {
		return UsuarioService.getInstance().autenticarUsuario(login);
	}

	public List<MesaDto> obtenerMesas(int sucursal_id, int mozoId, int CantComensales) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public PedidoDto confirmarAperturaMesa(int mesaId, int cantComensales,int mozoId) throws RemoteException {
		return SucursalService.getInstance().confirmarAperturaMesa(mesaId, cantComensales,mozoId);
	}
	
	public Map<String,Double> calcularComissionEnSucursal(int sucursalId) throws RemoteException {
		return MozoService.getInstance().calcularComissionEnSucursal(sucursalId);
	}
	
	public Double cerrarCaja(int sucursalId,double dineroEnCaja) throws RemoteException {
		return CajaService.getInstance().cerrarCaja(sucursalId, dineroEnCaja);
	}
	
	public void generarRemito() throws RemoteException{
		DepositoService.getInstance().generarRemito();
	}
}