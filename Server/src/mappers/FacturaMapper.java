package mappers;


import dominio.Factura;
import dto.FacturaDto;

public class FacturaMapper {
	
	private static FacturaMapper mapper;
	
	 public static FacturaMapper getMapper(){
	        if(mapper == null){
	            mapper = new FacturaMapper();
	        }

	        return mapper;
	    }
	 
	 public FacturaDto ToDto(Factura Factura){
		 	FacturaDto FacturaDto = new FacturaDto();
		 	FacturaDto.setNumeroFactura(Factura.getNumeroFactura());
		 	FacturaDto.setFecha(Factura.getFecha());
		 	FacturaDto.setMedioPago(Factura.getMedioPago());
		 	FacturaDto.setMonto(Factura.getMonto());
		 	FacturaDto.setPagado(Factura.isPagado());
	        return FacturaDto;
	    }

}
