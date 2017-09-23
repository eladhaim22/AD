package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "AsientosContables")
public class AsientoContable extends EntityClass {
	
	@OneToMany
	@JoinColumn(name = "asientocontable_id")
	private List<Factura> facturas = new ArrayList<Factura>();
	
	@Column(name = "fecha")
	private Date Fecha;
	
	@Column(name = "activo")
	private boolean esActivo;
}
