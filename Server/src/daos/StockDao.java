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
		return stock == null ? null : new StockEntity(stock.getStockId(),stock.getCantidadActual(),stock.getPuntoDeReposicion());
	}

	@Override
	public Stock toNegocio(StockEntity stockEntity) {
		return stockEntity == null ? null : new Stock(stockEntity.getStockId(),stockEntity.getCantidadActual(),stockEntity.getPuntoDeReposicion());
	}
}
