package mappers;

import java.util.ArrayList;
import java.util.List;

import dominio.Carta;
import dominio.Sector;
import dominio.Sucursal;
import dto.CartaDto;
import dto.SectorDto;
import dto.SucursalDto;

public class SucursalMapper {
	
	private static SucursalMapper mapper;
	
	 public static SucursalMapper getMapper(){
	        if(mapper == null){
	            mapper = new SucursalMapper();
	        }

	        return mapper;
	    }
	 
	 public SucursalDto ToDto(Sucursal Sucursal){
		 	SucursalDto SucursalDto = new SucursalDto();
		 	CartaMapper mapCar = new CartaMapper();
		 	List<CartaDto> cartasDto = new ArrayList<CartaDto>();
		 	for(Carta c : Sucursal.getCartas()){
		 		cartasDto.add(mapCar.ToDto(c));
		 	}
		 	SucursalDto.setCartas(cartasDto);
		 	SucursalDto.setDireccion(Sucursal.getDireccion());
		 	SucursalDto.setNombre(Sucursal.getNombre());
		 	SucursalDto.setEmail(Sucursal.getEmail());
		 	SucursalDto.setTelefono(Sucursal.getTelefono());
		 	SucursalDto.setSucursalId(Sucursal.getSucursalId());
		 	SectorMapper mapSec = new SectorMapper();
		 	List<SectorDto> SectoresDto = new ArrayList<SectorDto>();
		 	for(Sector s : Sucursal.getSectores()){
		 		SectoresDto.add(mapSec.ToDto(s));
		 	}
		 	SucursalDto.setSectores(SectoresDto);
		 	return SucursalDto;
	    }

}
