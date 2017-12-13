package dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usuarioLogin;
	private String password;
	
	
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
