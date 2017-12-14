package daos;

import java.util.List;

import entities.MozoEntity;
import hbt.GenericDao;
import model.Mozo;

public class MozoDao extends GenericDao<Mozo,MozoEntity>{
	
	 private static MozoDao dao;

	    public static MozoDao getDao(){
	        if(dao == null){
	            dao = new MozoDao();
	        }
	        return dao;
	    }

	@SuppressWarnings("unchecked")
	public List<MozoEntity> obtenerMozosSucursal(int sucursal_id){
		List<MozoEntity> lista = getHibernateTemplate().createQuery("select M from Sucursal S join S.sectores SS join SS.mozoAsociado M where S.sucursalId = :sucursal_id").setInteger("sucursal_id", sucursal_id).list();
		return lista;
	}

	@Override
	public MozoEntity toEntity(Mozo mozo) {
		return new MozoEntity(mozo.getId(),mozo.getNombre(),mozo.getPorcComision());
	}

	@Override
	public Mozo toNegocio(MozoEntity mozoEntity) {
		return new Mozo(mozoEntity.getId(),mozoEntity.getNombre(),mozoEntity.getPorcComision());
	}
}
