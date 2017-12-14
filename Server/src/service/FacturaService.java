package service;

import java.util.Date;

import daos.PedidoDao;
import entities.FacturaEntity;
import entities.ComandaEntity;
import entities.PedidoEntity;

public class FacturaService extends GenericService {
	
private static FacturaService instance;
	
	public static FacturaService getInstance(){
		if (instance==null)
			instance = new FacturaService();
		return instance;
	}

	public void generarFactura(int mesaId) {
		openSession();
		PedidoEntity p;
		p = PedidoDao.getDao().buscarPorMesa(mesaId);
		FacturaEntity f = new FacturaEntity();
		f.setFecha(new Date());
		float monto = 0;
		for(ComandaEntity ip : p.getComandas())
		{
			monto =+ ip.getItem().getPrecio()*ip.getCantidad();
		}
		f.setMonto(monto);
		p.setFactura(f);
		PedidoDao.getDao().Actualizar(p);
		commitAndCloseSession();
	}

}
