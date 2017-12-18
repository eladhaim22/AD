package daos;

import entities.ItemFacturaEntity;
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
        return itemFactura == null ? null : new ItemFacturaEntity(itemFactura.getId(),itemFactura.getNombrePlato(),itemFactura           .getCantidad(),itemFactura.getPrecio());
    }

    public ItemFactura toNegocio(ItemFacturaEntity itemFacturaEntity) {
        return itemFacturaEntity == null ? null : new ItemFactura(itemFacturaEntity.getId(),itemFacturaEntity.getNombrePlato(),                itemFacturaEntity.getCantidad(),itemFacturaEntity.getPrecio());
    }
}
