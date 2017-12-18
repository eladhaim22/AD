package daos;

import entities.*;
import model.*;

public class AreaDao extends GenericDao<Area, AreaEntity>{

	private static AreaDao dao;

    public static AreaDao getDao(){
        if(dao == null){
            dao = new AreaDao();
        }
        return dao;
    }

	@Override
	public AreaEntity toEntity(Area area) {
		AreaEntity areaEntity = null;
		if (area instanceof Cocina) {
			areaEntity = new CocinaEntity(area.getAreaId());
		}
		else {
			if (area instanceof Barra) {
				areaEntity = new BarraEntity(area.getAreaId());
			} else if(area instanceof Cafeteria){
				areaEntity = new CafeteriaEntity(area.getAreaId());
			}

		}
		return areaEntity;
	}

	@Override
	public Area toNegocio(AreaEntity areaEntity) {
		Area area = null;
		if (areaEntity instanceof CocinaEntity) {
			area = new Cocina(areaEntity.getAreaId());
		}
		else {
			if (areaEntity instanceof BarraEntity) {
				area = new Barra(areaEntity.getAreaId());
			} else if(areaEntity instanceof  CafeteriaEntity){
				area = new Cafeteria(areaEntity.getAreaId());
			}

		}
		return area;
	}
}
