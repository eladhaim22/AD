package daos;

import entities.CartaEntity;
import entities.ItemCartaEntity;
import entities.PresentacionEntity;
import hbt.GenericDao;
import model.Carta;
import model.Presentacion;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
		return new PresentacionEntity(presentacion.getPresentacionId(),presentacion.getNombre(),presentacion.getTamanio());
	}

	@Override
	public Presentacion toNegocio(PresentacionEntity presentacionEntity) {
		return new Presentacion(presentacionEntity.getPresentacionId(),presentacionEntity.getNombre(),
				presentacionEntity.getTamanio());
	}
}
