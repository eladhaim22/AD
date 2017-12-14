package service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import daos.LiquidacionDao;
import daos.MesaDao;
import daos.PedidoDao;
import entities.LiquidacionEntity;
import entities.MesaEntity;
import entities.MozoEntity;
import entities.PedidoEntity;

public class MozoService extends GenericService {
	
	private static MozoService instance;
	
	private MozoService() {};
	
	public static MozoService getInstance(){
		if (instance==null)
			instance = new MozoService();
		return instance;
	}

	public Map<String,Double> calcularComissionEnSucursal(int sucursalId) {
		openSession();
		List<MesaEntity> mesas = MesaDao.getDao().obtenerMesasPorSucursal(sucursalId);
		List<PedidoEntity> pedidos = PedidoDao.getDao().listarPedidosDeHoy(mesas);
		Map<MozoEntity, List<PedidoEntity>> mozosPedidos =
				pedidos.stream().collect(Collectors.groupingBy(PedidoEntity::getMozo));
		Map<String,Double> hashMapDtos = new HashMap<>();
		List<PedidoEntity> ps = null;
		for(MozoEntity mozo : mozosPedidos.keySet()) {
			Double comision = 0.0; 
			ps = mozosPedidos.get(mozo);
			for(PedidoEntity p : ps) {
				comision+=p.getComandas().stream().filter(item -> item.getItem().getPlatoAsociado().
						getRubro().compareTo("cafeteria") != 0)
				.mapToDouble(pr -> 
					mozo.calcularComision(pr.getCantidad() * pr.getItem().getPrecio(), 
							pr.getItem().getAdicionalComision())).sum();
			}
			LiquidacionEntity liquadacion = LiquidacionDao.getDao().obtenerLiquidacionDeLaFecha(mozo.getId());
			if(liquadacion != null) {
				liquadacion.setValue(comision);
			}
			else {
				Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
				Date date = Date.from(instant);
				liquadacion = new LiquidacionEntity();
				liquadacion.setUsuario(mozo);
				liquadacion.setFecha(date);
				liquadacion.setValue(comision);
			}
			LiquidacionDao.getDao().Guardar(liquadacion);
			hashMapDtos.put(mozo.getNombre(), comision);
		}
		
		commitAndCloseSession();
		return hashMapDtos;
	}
}
