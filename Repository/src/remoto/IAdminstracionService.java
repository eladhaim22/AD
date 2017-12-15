package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import dto.CartaDto;
import dto.ComandaDto;
import dto.FacturaDto;
import dto.ItemCartaDto;
import dto.LoginDto;
import dto.MesaDto;
import dto.MozoDto;
import dto.PedidoDto;
import dto.SectorDto;
import dto.SucursalDto;

public interface IAdminstracionService extends Remote {
	void cargarDatosIniciales() throws RemoteException;
	ItemCartaDto obtenerItemCartaById(int id) throws RemoteException;
	CartaDto obtenerCartaPorId(int cartaId) throws RemoteException;
	List<CartaDto> obtenerCartasPorSucursal(int sucursalId) throws RemoteException;
	void generarFactura(int mesaId) throws RemoteException;
	void cerrarMesa(int mesaId) throws RemoteException;
	List<MesaDto> obtenerMesas(int sucursal_id, int mozoId, int CantComensales) throws RemoteException;
	List<MesaDto> obtenerMesasAbiertaPorSucursal(int sucursalId) throws RemoteException;
	List<MesaDto> obtenerMesasDisponibles(int sucursal_id, int mozoId, int cantComensales) throws RemoteException;
	PedidoDto obtenerPedidoPorMesa(int mesaId) throws RemoteException;
	void agregarComandas(int pedidoId, List<ComandaDto> comandas) throws RemoteException;
	PedidoDto obtenerPedido(int pedidoId) throws RemoteException;
	List<SectorDto> obtenerSectores() throws RemoteException;
	List<SucursalDto> obtenerSucursales() throws RemoteException;
	List<MozoDto> obtenerMozos(int sucursal_id) throws RemoteException;
	PedidoDto confirmarAperturaMesa(int mesaId, int cantComensales,int mozoId) throws RemoteException;	
	List<MesaDto> getMesasImpagas(int sucursalId, int mozoId) throws RemoteException;
	FacturaDto getDatosFactura(int mesaId) throws RemoteException;
	void registrarPagoFactura(int facturaId, String medioPago, int mesaId) throws RemoteException;
	Map<String,Double> calcularComissionEnSucursal(int sucursalId) throws RemoteException;
	Double cerrarCaja(int sucursalId,double dineroEnCaja) throws RemoteException;
	void generarRemito() throws RemoteException;
}