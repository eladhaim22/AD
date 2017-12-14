package daos;

import entities.CartaEntity;
import entities.ComandaEntity;
import entities.ItemCartaEntity;
import hbt.GenericDao;
import model.Carta;
import model.Comanda;
import model.ItemCarta;

import java.util.Date;
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
		return new ComandaEntity(comanda.getId(),comanda.getCantidad(),comanda.getEstado(),
				PedidoDao.getDao().toEntity(comanda.getPedido()),ItemCartaDao.getDao().toEntity(comanda			.getItem()));
	}

	@Override
	public Comanda toNegocio(ComandaEntity comandaEntity) {
		return new Comanda(comandaEntity.getId(),comandaEntity.getCantidad(),comandaEntity.getEstado(),PedidoDao.getDao().toNegocio(comandaEntity.getPedido()),
				ItemCartaDao.getDao().toNegocio(comandaEntity.getItem()));
	}
}
