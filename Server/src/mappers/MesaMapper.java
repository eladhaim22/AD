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
        mesaDto.setId(mesa.getMesaId());
        mesaDto.setCapacidad(mesa.getCapacidad());
        mesaDto.setEmpty(mesa.isEmpty());
        mesaDto.setNumero(mesa.getNumeroMesa());
        mesaDto.setEmpty(mesa.isEstaPago());
        return mesaDto;
    }
}
