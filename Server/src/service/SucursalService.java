package service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daos.FacturaDao;
import daos.MesaDao;
import daos.MozoDao;
import daos.PedidoDao;
import daos.SucursalDao;
import dominio.Factura;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Pedido;
import dominio.Sucursal;
import dto.FacturaDto;
import dto.MesaDto;
import dto.MozoDto;
import dto.PedidoDto;
import dto.SucursalDto;
import mappers.FacturaMapper;
import mappers.MesaMapper;
import mappers.MozoMapper;
import mappers.PedidoMapper;
import mappers.SucursalMapper;

public class SucursalService extends GenericService{
	
	private static SucursalService instance;
	
	public static SucursalService getInstance(){
		if (instance==null)
			instance = new SucursalService();
		return instance;
	}
	
	public List<MozoDto> obtenerMozos(int sucursal_id) {
		openSession();
		List<Mozo> Mozos = MozoDao.getDao().obtenerMozosSucursal(sucursal_id);
		
		List<MozoDto> MozosDto = new ArrayList<MozoDto>();
		
		
		if(Mozos.size()>0){
			for(Mozo m :Mozos){
				MozoDto MozoDto = MozoMapper.getMapper().ToDto(m);
				MozosDto.add(MozoDto);
			}
		}

		commitAndCloseSession();
		return MozosDto;
	}
	
	public List<MesaDto> obtenerMesasAbiertaPorSucursal(int sucursalId) {
		openSession();
		List<Mesa> mesas = new MesaDao().obtenerMesasAbiertaPorSucursal(sucursalId);
		List<MesaDto> mesasDto = new ArrayList<MesaDto>();
		MesaMapper map = new MesaMapper();
		
		for(Mesa m : mesas){
			mesasDto.add(map.ToDto(m));
		}

		commitAndCloseSession();
		return mesasDto;
	}

	public void agregarSucursal(SucursalDto s){
		openSession();
		Sucursal sucursal = new Sucursal();
		sucursal.setDireccion(s.getDireccion());
		sucursal.setEmail(s.getEmail());
		sucursal.setNombre(s.getNombre());
		sucursal.setTelefono(s.getTelefono());
		
		SucursalDao.getDao().Guardar(sucursal);

		commitAndCloseSession();
	}
	
	public PedidoDto confirmarAperturaMesa(int mesaId, int cantComensales, int mozoId){
		openSession();
		Mesa mesaAsignada = MesaDao.getDao().Buscar(mesaId);		
		Pedido nuevoPedido = new Pedido();
		nuevoPedido.setCantComensales(cantComensales);
		nuevoPedido.setFechaApertura(new Date(System.currentTimeMillis()));
		nuevoPedido.setMesaAsociada(mesaAsignada);
		Mozo mozo = MozoDao.getDao().Buscar(mozoId);
		nuevoPedido.setMozo(mozo);
		mesaAsignada.setEmpty(false);
		mesaAsignada.setEstaPago(false);
		PedidoDao.getDao().Guardar(nuevoPedido);
		MesaDao.getDao().Actualizar(mesaAsignada);
		PedidoDto pedidoDto = PedidoMapper.getMapper().ToDto(nuevoPedido);
		commitAndCloseSession();
		return pedidoDto;
	}
	
	public List<MesaDto> getMesasImpagas(int sucursalId, int mozoId){
		openSession();
		List<Mesa> mesasImpagas = MesaDao.getDao().buscarMesasImpagas(sucursalId, mozoId);
		
		List<MesaDto> MesasDto = new ArrayList<MesaDto>();
		
		if(mesasImpagas.size()>0){
			for(Mesa m :mesasImpagas){
				MesaDto MesaDto = MesaMapper.getMapper().ToDto(m);
				MesasDto.add(MesaDto);
			}
		}

		commitAndCloseSession();
		return MesasDto;
		
	}
	
	public FacturaDto getDatosFactura(int mesaId){
		openSession();
		Pedido pedidoEncontrado = PedidoDao.getDao().buscarPorMesa(mesaId);
		Factura facturaEncontrada = FacturaDao.getDao().buscarNumeroPedido(pedidoEncontrado.getNumeroPedido());
		
		FacturaDto facturaDto = FacturaMapper.getMapper().ToDto(facturaEncontrada);
		commitAndCloseSession();
		return facturaDto;
	}
	
	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId){
		openSession();
		Factura facturaEncontrada = FacturaDao.getDao().Buscar(facturaId);
		facturaEncontrada.setMedioPago(medioPago);
		facturaEncontrada.setPagado(true);
		FacturaDao.getDao().Actualizar(facturaEncontrada);
		
		Pedido pedidoEncontrado = PedidoDao.getDao().buscarPorMesa(mesaId);
		pedidoEncontrado.setFechaCierre(new Date(System.currentTimeMillis()));
		PedidoDao.getDao().Actualizar(pedidoEncontrado);
		
		Mesa mesaEncontrada = MesaDao.getDao().Buscar(mesaId);
		mesaEncontrada.setEmpty(true);
		mesaEncontrada.setEstaPago(true);
		MesaDao.getDao().Actualizar(mesaEncontrada);

		commitAndCloseSession();
	}

	public List<SucursalDto> obtenerSucursales() throws RemoteException {
		openSession();
		List<Sucursal> sucursales = SucursalDao.getDao().ListarTodos();
		List<SucursalDto> sucursalesDto = new ArrayList<SucursalDto>();
		if(sucursales.size()>0){
			for(Sucursal s :sucursales){
				SucursalDto sucursalDto = SucursalMapper.getMapper().ToDto(s);
				sucursalesDto.add(sucursalDto);
			}
		}

		commitAndCloseSession();
		return sucursalesDto;
	}


}
