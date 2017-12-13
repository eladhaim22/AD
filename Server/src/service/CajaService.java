package service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import daos.FacturaDao;
import daos.LiquidacionDao;
import daos.MesaDao;
import daos.PedidoDao;
import daos.RegistroCajaDao;
import daos.SucursalDao;
import dominio.Liquidacion;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Pedido;
import dominio.RegistroCaja;
import dominio.Sucursal;

public class CajaService extends GenericService {
	
	private static CajaService instance;
	
	private CajaService() {};
	
	public static CajaService getInstance(){
		if (instance==null)
			instance = new CajaService();
		return instance;
	}

	public Double cerrarCaja(int sucursalId,double dineroEnCaja) {
		openSession();
		Double valorEsperado = null;
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		Date date = Date.from(instant);
		RegistroCaja registroCaja = RegistroCajaDao.getDao().getByDate(date, sucursalId);
		if(registroCaja == null) {
			List<Mesa> mesas = MesaDao.getDao().obtenerMesasPorSucursal(sucursalId);
			Sucursal sucurasl = SucursalDao.getDao().Buscar(sucursalId);
			valorEsperado = RegistroCajaDao.getDao().calcualrValorCajaEsperado(mesas);
			registroCaja = new RegistroCaja();
			registroCaja.setDate(date);
			registroCaja.setSucursal(sucurasl);
			registroCaja.setValorCaja(dineroEnCaja);
			registroCaja.setValorEsperado(valorEsperado);
			
			RegistroCajaDao.getDao().Guardar(registroCaja);
		}
		commitAndCloseSession();
		return valorEsperado == null ? null : valorEsperado - dineroEnCaja;
	}
}
