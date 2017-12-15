package daos;

import entities.MesaEntity;
import hbt.HibernateUtil;
import model.Mesa;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MesaDao extends GenericDao<Mesa,MesaEntity> {
	
    private static MesaDao dao;

    public static MesaDao getDao(){
        if(dao == null){
            dao = new MesaDao();
        }
        return dao;
    }
    
    public List<Mesa> ListarMesasDisponibles(int sucursal_id, int mozoId, int cantComensales){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<MesaEntity> returnValue = session.createQuery("Select M from Sucursal S join S.sectores SS join SS.mozoAsociado MZ join SS.mesas M where MZ.id = :mozoId and S.sucursalId = :sucursal_id and M.capacidad >= :cantComensales and M.isEmpty = true")
        															.setInteger("mozoId", mozoId).setInteger("sucursal_id", sucursal_id).setInteger("cantComensales", cantComensales).list();
        List<Mesa> mesas = new ArrayList<>();
        if(!returnValue.isEmpty()){
            mesas = returnValue.stream().map(mesaEntity -> this.toNegocio(mesaEntity)).collect(Collectors           .toList());
        }
        session.close();
        return  mesas;
    }
    
    public List<Mesa> buscarMesasImpagas(int sucursal_id, int mozoId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<MesaEntity> returnValue = session.createQuery("Select M from Sucursal S join S.sectores SS join SS.mozoAsociado MZ join SS.mesas M where MZ.id = :mozoId and S.sucursalId = :sucursal_id and M.estaPago = false and M.isEmpty = true")
        															.setInteger("mozoId", mozoId).setInteger("sucursal_id", sucursal_id).list();
        List<Mesa> mesas = new ArrayList<>();
        if(!returnValue.isEmpty()){
            mesas = returnValue.stream().map(mesaEntity -> this.toNegocio(mesaEntity)).collect(Collectors           .toList());
        }
        session.close();
        return  mesas;
    }
    
    public List<Mesa> obtenerMesasAbiertaPorSucursal(int sucursalId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<MesaEntity> returnValue = session.createQuery("Select M from Sucursal S join S.sectores SS join SS.mesas M where S.sucursalId = :sucursal_id and M.isEmpty = false")
																	.setInteger("sucursal_id", sucursalId).list();
        List<Mesa> mesas = new ArrayList<>();
        if(!returnValue.isEmpty()){
            mesas = returnValue.stream().map(mesaEntity -> this.toNegocio(mesaEntity)).collect(Collectors           .toList());
        }
        session.close();
        return  mesas;
    }
    public List<Mesa> obtenerMesasPorSucursal(int sucursalId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<MesaEntity> returnValue = session.createQuery("Select M from Sucursal S join S.sectores SS join SS.mesas M where S.sucursalId = :sucursal_id")
																	.setInteger("sucursal_id", sucursalId).list();
        List<Mesa> mesas = new ArrayList<>();
        if(!returnValue.isEmpty()){
            mesas = returnValue.stream().map(mesaEntity -> this.toNegocio(mesaEntity)).collect(Collectors           .toList());
        }
        session.close();
        return  mesas;
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
