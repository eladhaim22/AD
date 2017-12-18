package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import dto.*;

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
	PedidoDto confirmarAperturaMesa(int mesaId, int cantComensales,int mozoId,int sucursalId) throws RemoteException;
	List<MesaDto> getMesasImpagas(int sucursalId, int mozoId) throws RemoteException;
	FacturaDto getDatosFactura(int mesaId) throws RemoteException;
	void registrarPagoFactura(int facturaId, String medioPago, int mesaId) throws RemoteException;
	List<LiquidacionDto> calcularComissionEnSucursal(int sucursalId) throws RemoteException;
	RegistroCajaDto cerrarCaja(int sucursalId,double dineroEnCaja) throws RemoteException;
    void crearPlato(PlatoDto platoDto) throws RemoteException;
	List<PedidoDto> obtenerPedidosConComandasIniciadas() throws RemoteException;
	List<AreaDto> obtenerAreas() throws RemoteException;
	void aprobarComandas(List<Integer> comandasIds) throws RemoteException;
    List<IngredienteDto> obtenerIngredientes() throws RemoteException;
}