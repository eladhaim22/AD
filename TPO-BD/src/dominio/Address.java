package dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "cuidad")
	private String cuidad;
}
