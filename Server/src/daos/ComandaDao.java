package daos;

import entities.ComandaEntity;
import entities.FacturaEntity;
import hbt.HibernateUtil;
import model.Comanda;
import model.Factura;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComandaDao extends GenericDao<Comanda, ComandaEntity>{

	private static ComandaDao dao;

    public static ComandaDao getDao(){
        if(dao == null){
            dao = new ComandaDao();
        }
        return dao;
    }

	@Override
	public ComandaEntity toEntity(Comanda comanda) {
		return comanda == null ? null : new ComandaEntity(comanda.getId(),comanda.getCantidad(),comanda.getEstado(),ItemCartaDao.getDao().toEntity(comanda	.getItem()));
	}

	@Override
	public Comanda toNegocio(ComandaEntity comandaEntity) {
		return comandaEntity == null ? null : new Comanda(comandaEntity.getId(),comandaEntity.getCantidad(),comandaEntity.getEstado(),
				ItemCartaDao.getDao().toNegocio(comandaEntity.getItem()));
	}


}
