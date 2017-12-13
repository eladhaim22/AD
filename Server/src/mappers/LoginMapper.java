package mappers;

import dominio.Login;
import dto.LoginDto;

public class LoginMapper {
	
	private static LoginMapper mapper;
	
	 public static LoginMapper getMapper(){
	        if(mapper == null){
	            mapper = new LoginMapper();
	        }

	        return mapper;
	    }

	    public LoginDto ToDto(Login login){
	        LoginDto LoginDto = new LoginDto();
	        LoginDto.setPassword(login.getPassword());
	        LoginDto.setUsuarioLogin(login.getUsuarioLogin());
	        return LoginDto;
	    }

}
