package daos;

import entities.MarcaEntity;
import model.Marca;

public class MarcaDao extends GenericDao<Marca,MarcaEntity> {
	
	private static MarcaDao dao;

    public static MarcaDao getDao(){
        if(dao == null){
            dao = new MarcaDao();
        }
        return dao;
    }

    @Override
    public MarcaEntity toEntity(Marca marca) {
        return new MarcaEntity(marca.getId(),marca.getNombre(),marca.getNivel(),marca.getComentarios());
    }

    @Override
    public Marca toNegocio(MarcaEntity marcaEntity) {
        return new Marca(marcaEntity.getId(),marcaEntity.getNombre(),marcaEntity.getNivel(),marcaEntity.getComentarios());
    }
}
