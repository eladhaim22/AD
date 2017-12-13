package dominio;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="sectores")
public class Sector {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(nullable = false)
	private Integer numeroSector;
	
	@Column
	private String nombre;
	
	@OneToMany (cascade=CascadeType.ALL) // se pone EAGER para que cuando cargo el objeto traiga todos los objetos relacionados de la base de datos.
    @JoinColumn(name="numeroSector")
	private Set <Mesa> mesas = new HashSet<Mesa>();
	
	@Column
	private Integer cantMesas;
	
	@OneToOne
	private Mozo mozoAsociado;
	
	public Integer getNumeroSector() {
		return numeroSector;
	}

	public void setNumeroSector(Integer numeroSector) {
		this.numeroSector = numeroSector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Integer getCantMesas() {
		return cantMesas;
	}

	public void setCantMesas(Integer cantMesas) {
		this.cantMesas = cantMesas;
	}
}
