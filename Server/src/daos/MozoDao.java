package daos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.MozoEntity;
import hbt.HibernateUtil;
import model.Mozo;
import org.hibernate.Session;

public class MozoDao extends GenericDao<Mozo,MozoEntity>{
	
	 private static MozoDao dao;

	    public static MozoDao getDao(){
	        if(dao == null){
	            dao = new MozoDao();
	        }
	        return dao;
	    }


	@SuppressWarnings("unchecked")
	public List<Mozo> obtenerMozosSucursal(int sucursal_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<MozoEntity> lista = session.createQuery("select M from SucursalEntity S join S.sectores SS join SS.mozoAsociado M where S.sucursalId = :sucursal_id").setInteger("sucursal_id", sucursal_id).list();
		List<Mozo> mozos = new ArrayList<>();
		mozos = lista.stream().map(mozoEntity -> this.toNegocio(mozoEntity)).collect(Collectors.toList());
		session.close();
		return mozos;
	}

	@Override
	public MozoEntity toEntity(Mozo mozo) {
		return mozo == null ? null : new MozoEntity(mozo.getId(),mozo.getNombre(),mozo.getPorcComision());
	}

	@Override
	public Mozo toNegocio(MozoEntity mozoEntity) {
		return mozoEntity == null ? null : new Mozo(mozoEntity.getId(),mozoEntity.getNombre(),mozoEntity.getPorcComision());
	}
}
