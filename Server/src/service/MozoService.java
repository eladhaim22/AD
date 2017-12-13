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
import dominio.Liquidacion;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Pedido;

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
		List<Mesa> mesas = MesaDao.getDao().obtenerMesasPorSucursal(sucursalId);
		List<Pedido> pedidos = PedidoDao.getDao().listarPedidosDeHoy(mesas);
		Map<Mozo, List<Pedido>> mozosPedidos =
				pedidos.stream().collect(Collectors.groupingBy(Pedido::getMozo));	
		Map<String,Double> hashMapDtos = new HashMap<>();
		List<Pedido> ps = null;
		for(Mozo mozo : mozosPedidos.keySet()) {
			Double comision = 0.0; 
			ps = mozosPedidos.get(mozo);
			for(Pedido p : ps) {
				comision+=p.getItems().stream().filter(item -> item.getItem().getPlatoAsociado().
						getRubro().compareTo("cafeteria") != 0)
				.mapToDouble(pr -> 
					mozo.calcularComision(pr.getCantidad() * pr.getItem().getPrecio(), 
							pr.getItem().getAdicionalComision())).sum();
			}
			Liquidacion liquadacion = LiquidacionDao.getDao().obtenerLiquidacionDeLaFecha(mozo.getNroUsuario());
			if(liquadacion != null) {
				liquadacion.setValue(comision);
			}
			else {
				Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
				Date date = Date.from(instant);
				liquadacion = new Liquidacion();
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
