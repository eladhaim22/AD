package daos;

import entities.ComandaEntity;
import model.Comanda;



public class ComandaDao extends GenericDao<Comanda, ComandaEntity>{

	private static ComandaDao dao;

    public static ComandaDao getDao(){
        if(dao == null){
            dao = new ComandaDao();
        }
        return dao;
    }

	@Override
	public ComandaEntity toEntity(Comanda comanda) {
		return comanda == null ? null : new ComandaEntity(comanda.getId(),comanda.getCantidad(),comanda.getEstado(),ItemCartaDao.getDao().toEntity(comanda	.getItem()));
	}

	@Override
	public Comanda toNegocio(ComandaEntity comandaEntity) {
		return comandaEntity == null ? null : new Comanda(comandaEntity.getId(),comandaEntity.getCantidad(),comandaEntity.getEstado(),
				ItemCartaDao.getDao().toNegocio(comandaEntity.getItem()));
	}


}
