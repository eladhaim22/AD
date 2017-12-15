package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

import daos.*;
import dto.CartaDto;
import dto.FacturaDto;
import dto.ItemCartaDto;
import dto.ComandaDto;
import dto.MesaDto;
import dto.MozoDto;
import dto.PedidoDto;
import dto.SectorDto;
import dto.SucursalDto;
import model.*;
import remoto.IAdminstracionService;
import service.DepositoService;
import service.MozoService;
import service.SucursalService;

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
		Set<ItemFactura> itemFacturas = new HashSet<>();
		itemFacturas = pedido.getComandas().stream().map(comanda ->
			new ItemFactura(){{
				setCantidad(comanda.getCantidad());
				setNombrePlato(comanda.getItem().getPlatoAsociado().getNombre());
				setPrecio(comanda.getItem().getPrecio());
			}}
		).collect(Collectors.toSet());
		Factura factura = new Factura();
		factura.setItemsFactura(itemFacturas);
		factura.setFecha(new Date());
		factura.calcularFactura();
		pedido.setFactura(factura);
		pedido.save();
	}

	public void cerrarMesa(int mesaId) throws RemoteException {
		Mesa m = MesaDao.getDao().buscar(mesaId);
		if(m!=null)
		{
			m.setEmpty(true);
		}
		m.save();
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

	}

	public void actualizarPedido(PedidoDto pedidoDto) throws RemoteException {
		//PedidoDao.getDao().buscar(pedidoDto.getNumeroPedido());

		//PedidoService.getInstance().agregarItemPedido(pedidoId, comandas);
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
		return SucursalService.getInstance().getDatosFactura(mesaId);
	}

	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId) throws RemoteException{
		SucursalService.getInstance().registrarPagoFactura(facturaId, medioPago, mesaId);
	}

	public List<MesaDto> obtenerMesas(int sucursal_id, int mozoId, int CantComensales) throws RemoteException {
		MesaDao.getDao().ListarMesasDisponibles(sucursal_id,mozoId,CantComensales)
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
		nuevoPedido.save();
		mesaAsignada.save();
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
	
	public void generarRemito() throws RemoteException{
		DepositoService.getInstance().generarRemito();
	}
}