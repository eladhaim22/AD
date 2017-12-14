package daos;

import entities.CartaEntity;
import entities.ItemCartaEntity;
import hbt.GenericDao;
import model.Carta;
import model.ItemCarta;

public class ItemCartaDao extends GenericDao<ItemCarta, ItemCartaEntity> {

	private static ItemCartaDao dao;

    public static ItemCartaDao getDao(){
        if(dao == null){
            dao = new ItemCartaDao();
        }
        return dao;
    }

    public ItemCartaEntity toEntity(ItemCarta itemCarta) {
        return new ItemCartaEntity(itemCarta.getItemCartaId(),itemCarta.getPrecio(),
                PlatoDao.getDao().toEntity(itemCarta.getPlatoAsociado()),
                itemCarta.getAdicionalComision());
    }

    public ItemCarta toNegocio(ItemCartaEntity itemCartaEntity) {
        return new ItemCarta(itemCartaEntity.getItemCartaId(),itemCartaEntity.getPrecio(),
                PlatoDao.getDao().toNegocio(itemCartaEntity.getPlatoAsociado()),
                itemCartaEntity.getAdicionalComision());
    }
}
