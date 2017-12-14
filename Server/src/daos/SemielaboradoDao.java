package daos;

import entities.SemielaboradoEntity;
import hbt.GenericDao;
import model.Semielaborado;

import java.util.stream.Collectors;

public class SemielaboradoDao extends GenericDao<Semielaborado,SemielaboradoEntity>{

	private static SemielaboradoDao dao;

    public static SemielaboradoDao getDao(){
        if(dao == null){
            dao = new SemielaboradoDao();
        }
        return dao;
    }

    @Override
    public SemielaboradoEntity toEntity(Semielaborado semielaborado) {
        return new SemielaboradoEntity(semielaborado.getSeminelabodadoId(),
                semielaborado.getNombre(),semielaborado.getUnidadMedida(),
                semielaborado.getPorcionesXUnidad(),semielaborado.getTiempoElaboracionXUnidad(),
                semielaborado.getIngredientes().stream().map(ingrediente ->
                        IngredienteDAO.getDao().toEntity(ingrediente)).collect(Collectors.toSet()));
    }

    @Override
    public Semielaborado toNegocio(SemielaboradoEntity semielaboradoEntity) {
        return new Semielaborado(semielaboradoEntity.getSeminelabodadoId(),
                semielaboradoEntity.getNombre(),semielaboradoEntity.getUnidadMedida(),
                semielaboradoEntity.getPorcionesXUnidad(),semielaboradoEntity.getTiempoElaboracionXUnidad(),
                semielaboradoEntity.getIngredientes().stream().map(ingredienteEntity ->
                        IngredienteDAO.getDao().toNegocio(ingredienteEntity)).collect(Collectors.toSet()));
    }
}
