package mappers;

import entities.MesaEntity;
import dto.MesaDto;

public class MesaMapper {
    private static MesaMapper mapper;

    public static MesaMapper getMapper(){
        if(mapper == null){
            mapper = new MesaMapper();
        }

        return mapper;
    }

    public MesaDto ToDto(MesaEntity mesa){
        MesaDto mesaDto = new MesaDto();
        mesaDto.setId(mesa.getMesaId());
        mesaDto.setCapacidad(mesa.getCapacidad());
        mesaDto.setEmpty(mesa.isEmpty());
        mesaDto.setNumero(mesa.getNumeroMesa());
        mesaDto.setEmpty(mesa.isEstaPago());
        return mesaDto;
    }
}
