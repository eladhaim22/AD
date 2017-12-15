package daos;

import entities.*;
import entities.IngredienteProductoEntity;
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
		IngredienteEntity ingredienteEntity = null;
		if (ingrediente instanceof IngredienteProducto) {
			ingredienteEntity = new IngredienteProductoEntity(ingrediente.getIngredienteId(),
					ingrediente.getCantidad(), StockDao.getDao().toEntity(ingrediente.getStock()),
					ProductoDao.getDao().toEntity(((IngredienteProducto) ingrediente).getProductoAsociado()));
		}
		else {
			ingredienteEntity = new IngredienteSemielaboradoEntity(ingrediente.getIngredienteId(),
					ingrediente.getCantidad(), StockDao.getDao().toEntity(ingrediente.getStock()),
					SemielaboradoDao.getDao().toEntity(((IngredienteSemielaborado) ingrediente).getSemielaboradoAsociado()));
		}
		return ingredienteEntity;
	}

	@Override
	public Ingrediente toNegocio(IngredienteEntity ingredienteEntity) {
		Ingrediente ingrediente = null;
		if (ingredienteEntity instanceof IngredienteProductoEntity) {
			ingrediente = new IngredienteProducto(ingrediente.getIngredienteId(),
					ingrediente.getCantidad(), StockDao.getDao().toNegocio(ingredienteEntity.getStock()),
					ProductoDao.getDao().toNegocio(((IngredienteProductoEntity) ingredienteEntity).getProductoAsociado()));
		}
		else {
			ingrediente = new IngredienteSemielaborado(ingrediente.getIngredienteId(),
					ingrediente.getCantidad(), StockDao.getDao().toNegocio(ingredienteEntity.getStock()),
					SemielaboradoDao.getDao().toNegocio(((IngredienteSemielaboradoEntity) ingredienteEntity).getSemielaboradoAsociado()));
		}
		return ingrediente;
	}
}
