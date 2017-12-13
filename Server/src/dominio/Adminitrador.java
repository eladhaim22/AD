package dominio;

import javax.persistence.*;

@DiscriminatorValue("A")
public class Adminitrador extends Usuario{

	protected String obtenerTipo() {
		return TipoUsuario.A.toString();
	}
}
