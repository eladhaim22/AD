package daos;

import java.util.List;
import java.util.stream.Collectors;

import entities.SucursalEntity;
import model.Sucursal;

public class SucursalDao extends GenericDao<Sucursal,SucursalEntity> {

	private static SucursalDao dao;

    public static SucursalDao getDao(){
        if(dao == null){
            dao = new SucursalDao();
        }
        return dao;
    }


    @Override
    public SucursalEntity toEntity(Sucursal sucursal) {
        return sucursal == null ? null : new SucursalEntity(sucursal.getSucursalId(),sucursal.getNombre(),
                sucursal.getDireccion(),sucursal.getTelefono(),sucursal.getEmail(),
                sucursal.getCapacidadMaxima(),sucursal.getSectores().stream().map                           (sector -> SectorDao.getDao().toEntity(sector)).collect(Collectors.toList()),
                sucursal.getCartas().stream().map(carta ->
                        CartaDao.getDao().toEntity(carta)).collect(Collectors.toList()));
    }

    @Override
    public Sucursal toNegocio(SucursalEntity sucursalEntity) {
        return sucursalEntity == null ? null : new Sucursal(sucursalEntity.getSucursalId(),sucursalEntity.getNombre(),
                sucursalEntity.getDireccion(),sucursalEntity.getTelefono(),sucursalEntity.getEmail(),
                sucursalEntity.getCapacidadMaxima(),sucursalEntity.getSectores().stream().map                           (sectorEntity ->
                        SectorDao.getDao().toNegocio(sectorEntity)).collect(Collectors.toList()),
                        sucursalEntity.getCartas().stream().map(cartaEntity ->
                        CartaDao.getDao().toNegocio(cartaEntity)).collect(Collectors.toList()));
    }
}
