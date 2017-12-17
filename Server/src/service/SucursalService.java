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
import model.*;

public class SucursalService{
	
	private static SucursalService instance;
	
	public static SucursalService getInstance(){
		if (instance==null)
			instance = new SucursalService();
		return instance;
	}

	
	public Factura getDatosFactura(int mesaId){
		Pedido pedidoEncontrado = PedidoDao.getDao().buscarPorMesa(mesaId);
		Factura facturaEncontrada = FacturaDao.getDao().buscarNumeroPedido(pedidoEncontrado.getNumeroPedido());
		
		return facturaEncontrada;
	}
	
	public void registrarPagoFactura(int facturaId, String medioPago, int mesaId){
		Factura facturaEncontrada = FacturaDao.getDao().buscar(facturaId);
		facturaEncontrada.setMedioPago(medioPago);
		facturaEncontrada.setPagado(true);
		FacturaDao.getDao().save(facturaEncontrada);
		
		Pedido pedidoEncontrado = PedidoDao.getDao().buscarPorMesa(mesaId);
		pedidoEncontrado.setFechaCierre(new Date(System.currentTimeMillis()));
		PedidoDao.getDao().save(pedidoEncontrado);
		
		Mesa mesaEncontrada = MesaDao.getDao().buscar(mesaId);
		mesaEncontrada.setEmpty(true);
		mesaEncontrada.setEstaPago(true);
		MesaDao.getDao().save(mesaEncontrada);
	}



}
