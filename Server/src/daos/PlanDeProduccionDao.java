package daos;

import java.util.List;
import java.util.stream.Collectors;

import entities.PlanDeProduccionEntity;
import hbt.GenericDao;
import model.PlanDeProduccion;

public class PlanDeProduccionDao extends GenericDao<PlanDeProduccion,PlanDeProduccionEntity> {

	private static PlanDeProduccionDao dao;

    public static PlanDeProduccionDao getDao(){
        if(dao == null){
            dao = new PlanDeProduccionDao();
        }
        return dao;
    }
    
	public List<PlanDeProduccionEntity> obtenerPorSucursal(Integer sucursalId)
	{
		List<PlanDeProduccionEntity> list = getHibernateTemplate().createQuery("from PlanDeProduccion pp where pp.sucursalId = :sucirsalId ")
				.setInteger("sucursalId", sucursalId)
				.list();
		return list;
	}

	@Override
	public PlanDeProduccionEntity toEntity(PlanDeProduccion planDeProduccion) {
		return new PlanDeProduccionEntity(planDeProduccion.getId(),
				planDeProduccion.getItems().stream().map(itemPP ->
						ItemPPDao.getDao().toEntity(itemPP)).collect(Collectors.toList()),
				planDeProduccion.getNombre(),
				SucursalDao.getDao().toEntity(planDeProduccion.getSucursal()),
				AreaDao.getDao().toEntity(planDeProduccion.getArea()),
				planDeProduccion.getObjetivo());
	}

	@Override
	public PlanDeProduccion toNegocio(PlanDeProduccionEntity planDeProduccionEntity) {
		return new PlanDeProduccion(planDeProduccionEntity.getId(),
				planDeProduccionEntity.getItems().stream().map(itemPP -> ItemPPDao.getDao().toNegocio				(itemPP)).collect(Collectors.toList()),
				planDeProduccionEntity.getNombre(),
				SucursalDao.getDao().toNegocio(planDeProduccionEntity.getSucursal()),
				AreaDao.getDao().toNegocio(planDeProduccionEntity.getArea()),
				planDeProduccionEntity.getObjetivo());
	}
}
