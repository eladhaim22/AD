package daos;

import entities.ItemPPEntity;
import model.*;

public class ItemPPDao extends GenericDao<ItemPP, ItemPPEntity>{

	private static ItemPPDao dao;

    public static ItemPPDao getDao(){
        if(dao == null){
            dao = new ItemPPDao();
        }
        return dao;
    }

	@Override
	public ItemPPEntity toEntity(ItemPP itemPP) {
		return new ItemPPEntity(itemPP.getItemPPId(),SemielaboradoDao.getDao().toEntity(itemPP.getSemielaborado()),itemPP.getCantidad(),itemPP.isFinalizado_flag());
	}

	@Override
	public ItemPP toNegocio(ItemPPEntity itemPPEntity) {
		return new ItemPP(itemPPEntity.getItemPPId(),SemielaboradoDao.getDao().toNegocio(itemPPEntity.getSemielaborado()),itemPPEntity.getCantidad(),itemPPEntity.isFinalizado_flag());
	}
}
