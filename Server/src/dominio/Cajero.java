package dominio;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("C")
public class Cajero extends Usuario{
	
	protected String obtenerTipo() {
		return TipoUsuario.C.toString();
	}

}
