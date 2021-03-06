package daos;

import entities.PresentacionEntity;
import model.Presentacion;

public class PresentacionDao extends GenericDao<Presentacion, PresentacionEntity>{

	private static PresentacionDao dao;

    public static PresentacionDao getDao(){
        if(dao == null){
            dao = new PresentacionDao();
        }
        return dao;
    }

	@Override
	public PresentacionEntity toEntity(Presentacion presentacion) {
		return presentacion == null ? null : new PresentacionEntity(presentacion.getPresentacionId(),presentacion.getNombre(),presentacion.getTamanio());
	}

	@Override
	public Presentacion toNegocio(PresentacionEntity presentacionEntity) {
		return presentacionEntity == null ? null : new Presentacion(presentacionEntity.getPresentacionId(),presentacionEntity.getNombre(),
				presentacionEntity.getTamanio());
	}
}
