package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Sucursal")
public class Sucursal extends EntityClass {
	@Column(name = "nombre")
	private String nombre;
	
	@Embedded
	private Address direccion;
	
	@OneToOne
	@JoinColumn(name ="salon_id")
	private Salon salon;
	
	//@OneToOne
	//@JoinColumn(name ="cocina_id")
	@Transient
	private Cocina cocina;
	
	@OneToOne
	@JoinColumn(name ="carta_id")
	private Carta carta;
	
	@OneToOne
	@JoinColumn(name ="caja_id")
	private Caja caja;
	
	@Transient
	private Administracion administracion;
	
	@Transient
	private Deposito deposito;
	
	@OneToMany
	@JoinColumn(name = "sucursal_id")
	private List<Mozo> mozos = new ArrayList<Mozo>();
	
}
