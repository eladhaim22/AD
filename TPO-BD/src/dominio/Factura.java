package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Facturas")
public class Factura extends EntityClass {

	@Column(name = "fecha_de_pago")
	private Date FechaDePago;
	
	@Column(name = "fecha_de_cierre")
	private Date FechaDeCierre;
	
	@OneToOne
	@JoinColumn(name = "medioPago_id")
	private MedioPago medioPago;
	
	@OneToOne
	@JoinColumn(name = "mozo_id")
	private Mozo mozo;
	
	@OneToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;
	
	@OneToMany
	@JoinColumn(name = "factura_id")
	private List<ItemFactura> itemsFactura = new ArrayList<ItemFactura>();

}
