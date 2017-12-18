package daos;

import entities.*;
import model.*;

public class IngredienteDAO extends GenericDao<Ingrediente, IngredienteEntity>{

	private static IngredienteDAO dao;

    public static IngredienteDAO getDao(){
        if(dao == null){
            dao = new IngredienteDAO();
        }
        return dao;
    }

	@Override
	public IngredienteEntity toEntity(Ingrediente ingrediente) {
		return ingrediente == null ? null : new IngredienteEntity(ingrediente.getIngredienteId(),
					ingrediente.getNombre(), StockDao.getDao().toEntity(ingrediente.getStock()),
					ingrediente.getUnidadDeMedida());
	}

	@Override
	public Ingrediente toNegocio(IngredienteEntity ingredienteEntity) {
		return ingredienteEntity == null ? null : new Ingrediente(ingredienteEntity.getIngredienteId(),
				ingredienteEntity.getNombre(), StockDao.getDao().toNegocio(ingredienteEntity.getStock()),ingredienteEntity.getUnidadDeMedida());
	}
}
