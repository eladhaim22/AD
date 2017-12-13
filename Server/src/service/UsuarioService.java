package service;


import dominio.Login;
import dto.LoginDto;
import daos.LoginDao;

public class UsuarioService extends GenericService{
	
	private static UsuarioService instance;
	
	
	public static UsuarioService getInstance(){
		if (instance==null)
			instance = new UsuarioService();
		return instance;
	}


	public Boolean autenticarUsuario(LoginDto login) {
		openSession();
		Login l = new Login();
		l.setPassword(login.getPassword());
		l.setUsuarioLogin(login.getUsuarioLogin());
		
		boolean success = LoginDao.getDao().obtenerLogin(l) == null ? false : true;

		commitAndCloseSession();
		return success;
	}

}
