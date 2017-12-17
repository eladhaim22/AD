package service;

import java.util.Date;
import java.util.List;

import daos.SemielaboradoDao;
import model.*;

public class DepositoService {
	
private static DepositoService instance;
	
	public static DepositoService getInstance(){
		if (instance==null)
			instance = new DepositoService();
		return instance;
	}
	
	public void generarRemito(){
		Remito remito = new Remito();
		List<Semielaborado> Semielaborados = new SemielaboradoDao().ListarTodos();
		for(Semielaborado Semielaborado : Semielaborados){
			for(Ingrediente ingrediente : Semielaborado.getIngredientes()){
				if(ingrediente.getStock().getCantidadActual()<=ingrediente.getStock().getPuntoDeReposicion()){
					ItemRemito item=new ItemRemito();
					item.setCantidad(ingrediente.getStock().getPuntoDeReposicion());
					item.setIngrediente(ingrediente);
					java.util.Date fecha = new Date();
					remito.setFecha(fecha);
					remito.getItemsRemito().add(item);
					ingrediente.getStock().setCantidadActual(ingrediente.getStock().getCantidadActual()+ingrediente.getStock().getPuntoDeReposicion());
				}
			}
		}
		/*List<Producto> productos = new ProductoDao().ListarTodos();
		for(Producto Producto : productos){
			for(Ingrediente ingrediente : Producto.getIngredientes()){
				if(ingrediente.getStock().getCantidadActual()<=ingrediente.getStock().getPuntoDeReposicion()){
					ItemRemito item=new ItemRemito();
					item.setCantidad(ingrediente.getStock().getPuntoDeReposicion());
					item.setIngrediente(ingrediente);
					java.util.Date fecha = new Date();
					remito.setFecha(fecha);
					remito.getItemsRemito().add(item);
					ingrediente.getStock().setCantidadActual(ingrediente.getStock().getCantidadActual()+ingrediente.getStock().getPuntoDeReposicion());
				}
			}
		}*/
	}

}
