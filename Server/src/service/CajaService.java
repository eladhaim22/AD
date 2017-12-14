package service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import daos.MesaDao;
import daos.RegistroCajaDao;
import daos.SucursalDao;
import entities.MesaEntity;
import entities.RegistroCajaEntity;
import entities.SucursalEntity;

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
		RegistroCajaEntity registroCaja = RegistroCajaDao.getDao().getByDate(date, sucursalId);
		if(registroCaja == null) {
			List<MesaEntity> mesas = MesaDao.getDao().obtenerMesasPorSucursal(sucursalId);
			SucursalEntity sucurasl = SucursalDao.getDao().buscar(sucursalId);
			valorEsperado = RegistroCajaDao.getDao().calcualrValorCajaEsperado(mesas);
			registroCaja = new RegistroCajaEntity();
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
