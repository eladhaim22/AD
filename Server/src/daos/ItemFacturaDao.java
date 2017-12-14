package daos;

import entities.ItemCartaEntity;
import entities.ItemFacturaEntity;
import hbt.GenericDao;
import model.ItemCarta;
import model.ItemFactura;

public class ItemFacturaDao extends GenericDao<ItemFactura, ItemFacturaEntity> {

	private static ItemFacturaDao dao;

    public static ItemFacturaDao getDao(){
        if(dao == null){
            dao = new ItemFacturaDao();
        }
        return dao;
    }

    public ItemFacturaEntity toEntity(ItemFactura itemFactura) {
        return new ItemFacturaEntity(itemFactura.getId(),itemFactura.getNombrePlato(),itemFactura           .getCantidad(),itemFactura.getPrecio());
    }

    public ItemFactura toNegocio(ItemFacturaEntity itemFacturaEntity) {
        return new ItemFactura(itemFacturaEntity.getId(),itemFacturaEntity.getNombrePlato(),                itemFacturaEntity.getCantidad(),itemFacturaEntity.getPrecio());
    }
}
