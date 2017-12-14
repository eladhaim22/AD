package service;

import java.util.Date;
import java.util.List;

import daos.ProductoDao;
import daos.SemielaboradoDao;
import entities.IngredienteEntity;
import entities.ItemRemitoEntity;
import entities.ProductoEntity;
import entities.RemitoEntity;
import entities.SemielaboradoEntity;

public class DepositoService extends GenericService {
	
private static DepositoService instance;
	
	public static DepositoService getInstance(){
		if (instance==null)
			instance = new DepositoService();
		return instance;
	}
	
	public void generarRemito(){
		openSession();
		RemitoEntity remito = new RemitoEntity();
		List<SemielaboradoEntity> Semielaborados = new SemielaboradoDao().ListarTodos();
		for(SemielaboradoEntity Semielaborado : Semielaborados){
			for(IngredienteEntity ingrediente : Semielaborado.getIngredientes()){
				if(ingrediente.getStock().getCantidadActual()<=ingrediente.getStock().getPuntoDeReposicion()){
					ItemRemitoEntity item=new ItemRemitoEntity();
					item.setCantidad(ingrediente.getStock().getPuntoDeReposicion());
					item.setIngrediente(ingrediente);
					java.util.Date fecha = new Date();
					remito.setFecha(fecha);
					remito.getItemsRemito().add(item);
					ingrediente.getStock().setCantidadActual(ingrediente.getStock().getCantidadActual()+ingrediente.getStock().getPuntoDeReposicion());
				}
			}
		}
		List<ProductoEntity> productos = new ProductoDao().ListarTodos();
		for(ProductoEntity Producto : productos){
			for(IngredienteEntity ingrediente : Producto.getIngredientes()){
				if(ingrediente.getStock().getCantidadActual()<=ingrediente.getStock().getPuntoDeReposicion()){
					ItemRemitoEntity item=new ItemRemitoEntity();
					item.setCantidad(ingrediente.getStock().getPuntoDeReposicion());
					item.setIngrediente(ingrediente);
					java.util.Date fecha = new Date();
					remito.setFecha(fecha);
					remito.getItemsRemito().add(item);
					ingrediente.getStock().setCantidadActual(ingrediente.getStock().getCantidadActual()+ingrediente.getStock().getPuntoDeReposicion());
				}
			}
		}
		commitAndCloseSession();
	}

}
