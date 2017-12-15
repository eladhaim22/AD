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
import entities.*;
import entities.PedidoEntity;
import dto.FacturaDto;
import dto.MesaDto;
import dto.MozoDto;
import dto.PedidoDto;
import dto.SucursalDto;
import model.Mesa;
import model.Mozo;
import model.Pedido;
import model.Sucursal;

public class SucursalService extends GenericService{
	
	private static SucursalService instance;
	
	public static SucursalService getInstance(){
		if (instance==null)
			instance = new SucursalService();
		return instance;
	}


	public PedidoDto confirmarAperturaMesa(int mesaId, int cantComensales, int mozoId){

		PedidoDto pedidoDto = PedidoMapper.getMapper().ToDto(nuevoPedido);
		commitAndCloseSession();
		return pedidoDto;
	}

	
	public FacturaDto getDatosFactura(int mesaId){
		openSession();
		PedidoEntity pedidoEncontrado = PedidoDao.getDao().buscarPorMesa(mesaId);
		FacturaEntity facturaEncontrada = FacturaDao.getDao().buscarNumeroPedido(pedidoEncontrado.getNumeroPedido());
		
		FacturaDto facturaDto = FacturaMapper.getMapper().ToDto(facturaEncontrada);
		commitAndCloseSession();
		return facturaDto;
	}
	
	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId){
		openSession();
		FacturaEntity facturaEncontrada = FacturaDao.getDao().buscar(facturaId);
		facturaEncontrada.setMedioPago(medioPago);
		facturaEncontrada.setPagado(true);
		FacturaDao.getDao().Actualizar(facturaEncontrada);
		
		PedidoEntity pedidoEncontrado = PedidoDao.getDao().buscarPorMesa(mesaId);
		pedidoEncontrado.setFechaCierre(new Date(System.currentTimeMillis()));
		PedidoDao.getDao().Actualizar(pedidoEncontrado);
		
		MesaEntity mesaEncontrada = MesaDao.getDao().buscar(mesaId);
		mesaEncontrada.setEmpty(true);
		mesaEncontrada.setEstaPago(true);
		MesaDao.getDao().Actualizar(mesaEncontrada);

		commitAndCloseSession();
	}



}
