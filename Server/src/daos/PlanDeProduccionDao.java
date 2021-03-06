package daos;


import java.util.stream.Collectors;

import entities.PlanDeProduccionEntity;
import model.PlanDeProduccion;

public class PlanDeProduccionDao extends GenericDao<PlanDeProduccion,PlanDeProduccionEntity> {

	private static PlanDeProduccionDao dao;

    public static PlanDeProduccionDao getDao(){
        if(dao == null){
            dao = new PlanDeProduccionDao();
        }
        return dao;
    }
	
	@Override
	public PlanDeProduccionEntity toEntity(PlanDeProduccion planDeProduccion) {
		return planDeProduccion == null ? null : new PlanDeProduccionEntity(planDeProduccion.getId(),
				planDeProduccion.getItems().stream().map(itemPP ->
						ItemPPDao.getDao().toEntity(itemPP)).collect(Collectors.toList()),
				planDeProduccion.getNombre(),
				SucursalDao.getDao().toEntity(planDeProduccion.getSucursal()),
				AreaDao.getDao().toEntity(planDeProduccion.getArea()),
				planDeProduccion.getObjetivo());
	}

	@Override
	public PlanDeProduccion toNegocio(PlanDeProduccionEntity planDeProduccionEntity) {
		return planDeProduccionEntity == null ? null : new PlanDeProduccion(planDeProduccionEntity.getId(),
				planDeProduccionEntity.getItems().stream().map(itemPP -> ItemPPDao.getDao().toNegocio				(itemPP)).collect(Collectors.toList()),
				planDeProduccionEntity.getNombre(),
				SucursalDao.getDao().toNegocio(planDeProduccionEntity.getSucursal()),
				AreaDao.getDao().toNegocio(planDeProduccionEntity.getArea()),
				planDeProduccionEntity.getObjetivo());
	}
}
