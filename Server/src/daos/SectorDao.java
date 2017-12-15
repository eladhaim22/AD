package daos;

import entities.SectorEntity;
import model.Sector;

import java.util.stream.Collectors;

public class SectorDao extends GenericDao<Sector,SectorEntity> {
	
	private static SectorDao dao;

    public static SectorDao getDao(){
        if(dao == null){
            dao = new SectorDao();
        }
        return dao;
    }

    @Override
    public SectorEntity toEntity(Sector sector) {
        return new SectorEntity(sector.getNumeroSector(),sector.getNombre(),
                sector.getMesas().stream().map(mesa -> MesaDao.getDao().toEntity(mesa))
                .collect(Collectors.toSet()),
                sector.getCantMesas(),MozoDao.getDao().toEntity(sector.getMozoAsociado()));
    }

    @Override
    public Sector toNegocio(SectorEntity sectorEntity) {
        return new Sector(sectorEntity.getNumeroSector(),sectorEntity.getNombre(),
                sectorEntity.getMesas().stream().map(mesa -> MesaDao.getDao().toNegocio(mesa))
                        .collect(Collectors.toSet()),
                sectorEntity.getCantMesas(),MozoDao.getDao().toNegocio(sectorEntity.getMozoAsociado()));
    }
}
