package daos;

import entities.StockEntity;
import model.*;

public class StockDao extends GenericDao<Stock, StockEntity> {

	private static StockDao dao;

	public static StockDao getDao() {
		if (dao == null) {
			dao = new StockDao();
		}
		return dao;
	}

	@Override
	public StockEntity toEntity(Stock stock) {
		return new StockEntity(stock.getStockId(),stock.getCantidadActual(),stock.getPuntoDeReposicion());
	}

	@Override
	public Stock toNegocio(StockEntity stockEntity) {
		return new Stock(stockEntity.getStockId(),stockEntity.getCantidadActual(),stockEntity.getPuntoDeReposicion());
	}
}
