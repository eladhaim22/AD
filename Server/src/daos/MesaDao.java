package daos;

import dominio.Mesa;
import hbt.GenericDao;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;

public class MesaDao extends GenericDao<Mesa> {
	
    private static MesaDao dao;

    public static MesaDao getDao(){
        if(dao == null){
            dao = new MesaDao();
        }
        return dao;
    }
    
    public List<Mesa> ListarMesasDisponibles(int sucursal_id, int mozoId, int cantComensales){
        List<Mesa> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mozoAsociado MZ join SS.mesas M where MZ.nroUsuario = :mozoId and S.sucursalId = :sucursal_id and M.capacidad >= :cantComensales and M.isEmpty = true")
        															.setInteger("mozoId", mozoId).setInteger("sucursal_id", sucursal_id).setInteger("cantComensales", cantComensales).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
    
    public List<Mesa> buscarMesasImpagas(int sucursal_id, int mozoId){
        List<Mesa> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mozoAsociado MZ join SS.mesas M where MZ.nroUsuario = :mozoId and S.sucursalId = :sucursal_id and M.estaPago = false and M.isEmpty = true")
        															.setInteger("mozoId", mozoId).setInteger("sucursal_id", sucursal_id).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
    
    public List<Mesa> obtenerMesasAbiertaPorSucursal(int sucursalId){
        List<Mesa> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mesas M where S.sucursalId = :sucursal_id and M.isEmpty = false")
																	.setInteger("sucursal_id", sucursalId).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
    public List<Mesa> obtenerMesasPorSucursal(int sucursalId){
        List<Mesa> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mesas M where S.sucursalId = :sucursal_id")
																	.setInteger("sucursal_id", sucursalId).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
}
