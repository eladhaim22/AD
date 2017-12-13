package dominio;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
	
	@Id
	private String usuarioLogin;
	private String password;
	@OneToOne
	private Usuario usuario;
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
