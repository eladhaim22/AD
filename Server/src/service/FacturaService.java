package service;

import java.util.Date;

import daos.FacturaDao;
import daos.PedidoDao;
import dominio.Factura;
import dominio.ItemPedido;
import dominio.Pedido;

public class FacturaService extends GenericService {
	
private static FacturaService instance;
	
	public static FacturaService getInstance(){
		if (instance==null)
			instance = new FacturaService();
		return instance;
	}

	public void generarFactura(int mesaId) {
		openSession();
		Pedido p;
		p = PedidoDao.getDao().buscarPorMesa(mesaId);
		Factura f = new Factura();
		f.setFecha(new Date());
		float monto = 0;
		for(ItemPedido ip : p.getItems())
		{
			monto =+ ip.getItem().getPrecio()*ip.getCantidad();
		}
		f.setMonto(monto);
		p.setFactura(f);
		PedidoDao.getDao().Actualizar(p);
		commitAndCloseSession();
	}

}
