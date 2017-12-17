package daos;

import entities.PlatoEntity;
import model.Plato;

import java.util.stream.Collectors;

public class PlatoDao extends GenericDao<Plato,PlatoEntity>{
	
	private static PlatoDao dao;

    public static PlatoDao getDao(){
        if(dao == null){
            dao = new PlatoDao();
        }
        return dao;
    }

    public PlatoEntity toEntity(Plato plato) {
        return new PlatoEntity(plato.getPlatoId(),plato.getNombre(),plato.getUnidadMedida(),
                plato.getPorcionesXUnidad(),plato.getComentarios(),plato.getRubro(),
                plato.getItemsIngredientes().stream().map(itemIngrediente ->  ItemIngredienteDAO.getDao().toEntity                   (itemIngrediente)).collect(Collectors.toSet()),AreaDao.getDao().toEntity(plato.getArea()),plato.getReceta());
    }

    public Plato toNegocio(PlatoEntity platoEntity){
        return new Plato(platoEntity.getPlatoId(),platoEntity.getNombre(),platoEntity.getUnidadMedida(),
                platoEntity.getPorcionesXUnidad(),platoEntity.getComentarios(),platoEntity.getRubro(),          platoEntity.getItemsIngredientes().stream().map(itemIngrediente ->  ItemIngredienteDAO.getDao().toNegocio                   (itemIngrediente)).collect(Collectors.toSet()),
                AreaDao.getDao().toNegocio(platoEntity.getArea()),platoEntity.getReceta());
}
}
