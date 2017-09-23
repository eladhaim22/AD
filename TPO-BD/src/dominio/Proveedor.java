package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Proveedors")
public class Proveedor extends EntityClass {
	
	@Column(name = "cuit")
	private String cuit;

	@Column(name = "razonSocial")
	private String razonSocial;
}
