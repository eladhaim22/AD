package daos;

import entities.ItemIngredienteEntity;
import model.ItemIngrediente;

public class ItemIngredienteDAO extends GenericDao<ItemIngrediente, ItemIngredienteEntity>{

	private static ItemIngredienteDAO dao;

    public static ItemIngredienteDAO getDao(){
        if(dao == null){
            dao = new ItemIngredienteDAO();
        }
        return dao;
    }

	@Override
	public ItemIngredienteEntity toEntity(ItemIngrediente itemIngrediente) {
		return itemIngrediente == null ? null : new ItemIngredienteEntity(itemIngrediente.getId(),
					IngredienteDAO.getDao().toEntity(itemIngrediente.getIngrediente()),
					itemIngrediente.getCantidad());
	}

	@Override
	public ItemIngrediente toNegocio(ItemIngredienteEntity itemIngredienteEntity) {
		return itemIngredienteEntity == null ? null : new ItemIngrediente(itemIngredienteEntity.getId(),
				IngredienteDAO.getDao().toNegocio(itemIngredienteEntity.getIngrediente()),
					itemIngredienteEntity.getCantidad());
	}
}
