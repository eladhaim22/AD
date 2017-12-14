package daos;

import entities.ProductoEntity;
import hbt.GenericDao;
import model.Presentacion;
import model.Producto;

import java.util.stream.Collectors;

public class ProductoDao extends GenericDao<Producto,ProductoEntity>{

	private static ProductoDao dao;

    public static ProductoDao getDao(){
        if(dao == null){
            dao = new ProductoDao();
        }
        return dao;
    }

    @Override
    public ProductoEntity toEntity(Producto producto) {
        return new ProductoEntity(producto.getProductoId(),producto.getNombre(),
                producto.getComestible(),producto.getUnidadMedida(),
                producto.getPresentaciones().stream().map(presentacion ->
                        PresentacionDao.getDao().toEntity(presentacion)).collect(Collectors.toSet())
                ,producto.getIngredientes().stream().map(ingrediente ->
                IngredienteDAO.getDao().toEntity(ingrediente)).collect(Collectors.toSet()                              ), producto.getMarcas().stream().map(marca ->
                MarcaDao.getDao().toEntity(marca)).collect(Collectors.toSet()));
    }

    @Override
    public Producto toNegocio(ProductoEntity productoEntity) {
        return new Producto(productoEntity.getProductoId(),productoEntity.getNombre(),
                productoEntity.getComestible(),productoEntity.getUnidadMedida(),
                productoEntity.getPresentaciones().stream().map(presentacionEntity ->
                        PresentacionDao.getDao().toNegocio(presentacionEntity)).collect(Collectors.toSet())
                ,productoEntity.getIngredientes().stream().map(ingredienteEntity ->
                        IngredienteDAO.getDao().toNegocio(ingredienteEntity)).collect(Collectors.toSet()               ), productoEntity.getMarcas().stream().map(marcaEntity ->
                MarcaDao.getDao().toNegocio(marcaEntity)).collect(Collectors.toSet()));
    }
}
