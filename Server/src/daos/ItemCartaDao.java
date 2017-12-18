package daos;

import entities.ItemCartaEntity;
import hbt.HibernateUtil;
import model.ItemCarta;
import org.hibernate.Session;

public class ItemCartaDao extends GenericDao<ItemCarta, ItemCartaEntity> {

	private static ItemCartaDao dao;

    public static ItemCartaDao getDao(){
        if(dao == null){
            dao = new ItemCartaDao();
        }
        return dao;
    }

    public ItemCarta obtenerItemCartaById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ItemCartaEntity objetoEncontrado;
        objetoEncontrado = (ItemCartaEntity)session.get(ItemCartaEntity.class, id);
        ItemCarta itemCarta = this.toNegocio(objetoEncontrado);
        session.close();
        return itemCarta;
    }

    public ItemCartaEntity toEntity(ItemCarta itemCarta) {
        return itemCarta == null ? null : new ItemCartaEntity(itemCarta.getItemCartaId(),itemCarta.getPrecio(),
                PlatoDao.getDao().toEntity(itemCarta.getPlatoAsociado()),
                itemCarta.getAdicionalComision());
    }

    public ItemCarta toNegocio(ItemCartaEntity itemCartaEntity) {
        return itemCartaEntity == null ? null : new ItemCarta(itemCartaEntity.getItemCartaId(),itemCartaEntity.getPrecio(),
                PlatoDao.getDao().toNegocio(itemCartaEntity.getPlatoAsociado()),
                itemCartaEntity.getAdicionalComision());
    }
}
