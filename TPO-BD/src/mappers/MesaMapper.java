package mappers;

import dominio.Mesa;
import dto.MesaDto;

public class MesaMapper {
    private static MesaMapper mapper;

    public static MesaMapper getMapper(){
        if(mapper == null){
            mapper = new MesaMapper();
        }

        return mapper;
    }

    public MesaDto ToDto(Mesa mesa){
        MesaDto mesaDto = new MesaDto();
        mesaDto.setCapacidad(mesa.getCapacidad());
        mesaDto.setEmpty(mesa.isEmpty());
        mesaDto.setMozoId(mesa.getMozo().getId());
        mesaDto.setNumero(mesa.getNumero());
        return mesaDto;
    }
}
