package daos;

import entities.MesaEntity;
import hbt.GenericDao;
import model.Mesa;

import java.util.List;

public class MesaDao extends GenericDao<Mesa,MesaEntity> {
	
    private static MesaDao dao;

    public static MesaDao getDao(){
        if(dao == null){
            dao = new MesaDao();
        }
        return dao;
    }
    
    public List<MesaEntity> ListarMesasDisponibles(int sucursal_id, int mozoId, int cantComensales){
        List<MesaEntity> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mozoAsociado MZ join SS.mesas M where MZ.id = :mozoId and S.sucursalId = :sucursal_id and M.capacidad >= :cantComensales and M.isEmpty = true")
        															.setInteger("mozoId", mozoId).setInteger("sucursal_id", sucursal_id).setInteger("cantComensales", cantComensales).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
    
    public List<MesaEntity> buscarMesasImpagas(int sucursal_id, int mozoId){
        List<MesaEntity> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mozoAsociado MZ join SS.mesas M where MZ.id = :mozoId and S.sucursalId = :sucursal_id and M.estaPago = false and M.isEmpty = true")
        															.setInteger("mozoId", mozoId).setInteger("sucursal_id", sucursal_id).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
    
    public List<MesaEntity> obtenerMesasAbiertaPorSucursal(int sucursalId){
        List<MesaEntity> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mesas M where S.sucursalId = :sucursal_id and M.isEmpty = false")
																	.setInteger("sucursal_id", sucursalId).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }
    public List<MesaEntity> obtenerMesasPorSucursal(int sucursalId){
        List<MesaEntity> returnValue = getHibernateTemplate().createQuery("Select M from Sucursal S join S.sectores SS join SS.mesas M where S.sucursalId = :sucursal_id")
																	.setInteger("sucursal_id", sucursalId).list();
        if(!returnValue.isEmpty()){
            return returnValue;
        }else{
            return null;
        }
    }

    @Override
    public MesaEntity toEntity(Mesa mesa) {
        return new MesaEntity(mesa.getMesaId(),mesa.getNumeroMesa(),mesa.getCapacidad(),mesa.isEmpty(),mesa.isEstaPago());
    }

    @Override
    public Mesa toNegocio(MesaEntity mesaEntity) {
        return new Mesa(mesaEntity.getMesaId(),mesaEntity.getNumeroMesa(),mesaEntity.getCapacidad(),mesaEntity.isEmpty(),mesaEntity.isEstaPago());
    }
}
