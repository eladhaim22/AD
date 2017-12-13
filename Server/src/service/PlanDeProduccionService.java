package service;

import java.util.List;

import daos.PlanDeProduccionDao;
import daos.SemielaboradoDao;
import dominio.ItemPP;
import dominio.PlanDeProduccion;
import dominio.Semielaborado;

public class PlanDeProduccionService extends GenericService {

	private static PlanDeProduccionService instance;
	
	public static PlanDeProduccionService getInstance(){
		if (instance==null)
			instance = new PlanDeProduccionService();
		return instance;
	}
	/*revisa la cantidad de semiElaborados producidos con respecto al objetivos de cantidad a producir, si produce un 60% o mas,
	  se agrega un producto mas a producir*/
	public void controlarPlanDeEjecucionPorSucursal(int sucursalId, int cantidad, int semielaboradoId){
		openSession();
		PlanDeProduccionDao planDao= new PlanDeProduccionDao();
		List<PlanDeProduccion> planes = planDao.obtenerPorSucursal(sucursalId);
		int SemiElaboradosProducidos=0;
		for(PlanDeProduccion plan : planes){
			for(ItemPP item : plan.getItems()){
				SemiElaboradosProducidos=SemiElaboradosProducidos+item.getCantidad();
			}
			if(SemiElaboradosProducidos >= plan.getObjetivo() * 0.6){
				Semielaborado semiElaborado = new SemielaboradoDao().Buscar(semielaboradoId);
				ItemPP item = new ItemPP();
				item.setCantidad(cantidad);
				item.setSemielaborado(semiElaborado);
				item.setFinalizado_flag(false);
				plan.getItems().add(item);
			}
		}
		commitAndCloseSession();
	}
	
}
