package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

import daos.*;
import dto.*;
import model.*;
import remoto.IAdminstracionService;
import service.MozoService;

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
		return ItemCartaDao.getDao().obtenerItemCartaById(id).toDto();
	}

	public CartaDto obtenerCartaPorId(int cartaId) throws RemoteException {
		return CartaDao.getDao().buscar(cartaId).toDto();
	}

	public List<CartaDto> obtenerCartasPorSucursal(int sucursalId) throws RemoteException {
		return CartaDao.getDao().obtenerCartasPorSucursal(sucursalId).stream()
				.map(carta -> carta.toDto()).collect(Collectors.toList());
	}

	public void generarFactura(int mesaId) throws RemoteException {
		Pedido pedido = PedidoDao.getDao().buscarPorMesa(mesaId);
		Factura factura = new Factura();
		pedido.setFactura(factura.generarFactura(pedido));
		pedido.update();
	}

	public void cerrarMesa(int mesaId) throws RemoteException {
		Mesa m = MesaDao.getDao().buscar(mesaId);
		if(m!=null)
		{
			m.setEmpty(true);
		}
		m.update();
	}

	public List<MesaDto> obtenerMesasAbiertaPorSucursal(int sucursalId) throws RemoteException {
		return MesaDao.getDao().obtenerMesasAbiertaPorSucursal(sucursalId)
				.stream().map(mesa -> mesa.toDto()).collect(Collectors.toList());
	}

	public List<MesaDto> obtenerMesasDisponibles(int sucursal_id, int mozoId, int cantComensales)
			throws RemoteException {
		return MesaDao.getDao().ListarMesasDisponibles(sucursal_id, mozoId, cantComensales)
				.stream().map(mesa -> mesa.toDto()).collect(Collectors.toList());
	}

	public PedidoDto obtenerPedidoPorMesa(int mesaId) throws RemoteException {
		return PedidoDao.getDao().buscarPorMesa(mesaId).toDto();
	}

	@Override
	public void agregarComandas(int pedidoId, List<ComandaDto> comandas) throws RemoteException {
		Pedido pedido = PedidoDao.getDao().buscar(pedidoId);
		pedido.agregarComandas(comandas);
	}

	public List<PedidoDto> obtenerPedidosConComandasIniciadas() throws RemoteException{
		return PedidoDao.getDao().obtenerPedidosConComandasIniciadas().stream().map(pedido ->
		pedido.toDto()).collect(Collectors.toList());
	}

	public void aprobarComandas(List<Integer> comandasIds) throws RemoteException{
		List<Comanda> comandas = comandasIds.stream().map(comandaId -> ComandaDao.getDao()
		.buscar(comandaId)).collect(Collectors.toList());
		for(Comanda c : comandas){
			c.setEstado("Finalizado");
			c.getItem().getPlatoAsociado().descontarStock(c.getCantidad());
			c.save();
		}
	}

	public PedidoDto obtenerPedido(int pedidoId) throws RemoteException{
		return PedidoDao.getDao().buscar(pedidoId).toDto();
	}

	public List<SectorDto> obtenerSectores() throws RemoteException{
		return SectorDao.getDao().ListarTodos().stream()
				.map(sector -> sector.toDto()).collect(Collectors.toList());
	}

	public List<SucursalDto> obtenerSucursales() throws RemoteException{
		return SucursalDao.getDao().ListarTodos().stream()
				.map(sucursal -> sucursal.toDto()).collect(Collectors.toList());
	}

	public List<MozoDto> obtenerMozos(int sucursal_id) throws RemoteException{
		return MozoDao.getDao().obtenerMozosSucursal(sucursal_id).stream()
				.map(mozo -> mozo.toDto()).collect(Collectors.toList());
	}
	
	public List<MesaDto> getMesasImpagas(int sucursalId, int mozoId) throws RemoteException{
		return MesaDao.getDao().buscarMesasImpagas(sucursalId,mozoId)
 				.stream().map(mesa -> mesa.toDto()).collect(Collectors.toList());
	}

	public FacturaDto getDatosFactura(int mesaId) throws RemoteException{
		Factura factura = FacturaDao.getDao().obtenerFacturaImpagaPorMesa(mesaId);
		return factura.toDto();
	}

	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId) throws RemoteException{
		Factura factura = FacturaDao.getDao().buscar(facturaId);
		factura.cerrarFactura(medioPago);
		Pedido pedido = PedidoDao.getDao().buscarPorMesa(mesaId);
		pedido.cerrarPedido();
		Mesa mesa = MesaDao.getDao().buscar(mesaId);
		mesa.cerrarMesa();
	}

	public List<MesaDto> obtenerMesas(int sucursal_id, int mozoId, int CantComensales) throws RemoteException {
		return MesaDao.getDao().ListarMesasDisponibles(sucursal_id,mozoId,CantComensales)
				.stream().map(mesa -> mesa.toDto()).collect(Collectors.toList());
	}

	public PedidoDto confirmarAperturaMesa(int mesaId, int cantComensales,int mozoId) throws RemoteException {
		Mesa mesaAsignada = MesaDao.getDao().buscar(mesaId);
		Pedido nuevoPedido = new Pedido();
		nuevoPedido.setCantComensales(cantComensales);
		nuevoPedido.setFechaApertura(new Date(System.currentTimeMillis()));
		nuevoPedido.setMesaAsociada(mesaAsignada);
		Mozo mozo = MozoDao.getDao().buscar(mozoId);
		nuevoPedido.setMozo(mozo);
		mesaAsignada.setEmpty(false);
		mesaAsignada.setEstaPago(false);
		nuevoPedido = nuevoPedido.save();
		mesaAsignada.update();
		return nuevoPedido.toDto();
	}
	
	public Map<String,Double> calcularComissionEnSucursal(int sucursalId) throws RemoteException {
		return MozoService.getInstance().calcularComissionEnSucursal(sucursalId);
	}
	
	public Double cerrarCaja(int sucursalId,double dineroEnCaja) throws RemoteException {
		RegistroCaja registroCaja = RegistroCajaDao.getDao().getByDate(new Date(),sucursalId);
		if(registroCaja == null){
			registroCaja = new RegistroCaja();
		}
		registroCaja.setDate(new Date());
		registroCaja.setSucursal(SucursalDao.getDao().buscar(sucursalId));
		registroCaja.setValorCaja(dineroEnCaja);
		List<Factura> facturas = FacturaDao.getDao().obtenerFacturasDeHoy(sucursalId);
		return registroCaja.cerrarCaja(facturas);
	}

	public void crearPlato(PlatoDto platoDto) throws RemoteException{
		Plato plato = new Plato(null,platoDto.getNombre(),platoDto.getUnidadMedida(),
				platoDto.getPorcionesXUnidad(),platoDto.getComentarios(),platoDto.getRubro(),
				platoDto.getIngredients().stream().map(itemIngredienteDTO -> new ItemIngrediente(null,IngredienteDAO.getDao().buscar(itemIngredienteDTO.getIngrediente()),itemIngredienteDTO.getCantidad())).collect(Collectors.toSet()),AreaDao.getDao().buscar(platoDto.getAreaId()),
				platoDto.getReceta());
		plato.save();
	}


	@Override
	public List<AreaDto> obtenerAreas() throws RemoteException {
		return AreaDao.getDao().ListarTodos().stream().map(area -> area.toDto()).collect(Collectors.toList());
	}

	@Override
	public List<IngredienteDto> obtenerIngredientes() throws RemoteException {
		return IngredienteDAO.getDao().ListarTodos().stream().map(ingrediente ->
		ingrediente.toDto()).collect(Collectors.toList());
	}

}