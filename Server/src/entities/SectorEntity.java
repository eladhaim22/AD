package entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="sectores")
public class SectorEntity {

	public SectorEntity() {
	}

	public SectorEntity(Integer numeroSector, String nombre, Set<MesaEntity> mesas, Integer cantMesas, MozoEntity mozoAsociado) {
		this.numeroSector = numeroSector;
		this.nombre = nombre;
		this.mesas = mesas;
		this.cantMesas = cantMesas;
		this.mozoAsociado = mozoAsociado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(nullable = false)
	private Integer numeroSector;
	
	@Column
	private String nombre;
	
	@OneToMany (cascade=CascadeType.ALL) // se pone EAGER para que cuando cargo el objeto traiga todos los objetos relacionados de la base de datos.
    @JoinColumn(name="numeroSector")
	private Set <MesaEntity> mesas = new HashSet<MesaEntity>();
	
	@Column
	private Integer cantMesas;
	
	@OneToOne
	private MozoEntity mozoAsociado;

	public MozoEntity getMozoAsociado() {
		return mozoAsociado;
	}

	public void setMozoAsociado(MozoEntity mozoAsociado) {
		this.mozoAsociado = mozoAsociado;
	}

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

	public Set<MesaEntity> getMesas() {
		return mesas;
	}

	public void setMesas(Set<MesaEntity> mesas) {
		this.mesas = mesas;
	}

	public Integer getCantMesas() {
		return cantMesas;
	}

	public void setCantMesas(Integer cantMesas) {
		this.cantMesas = cantMesas;
	}
}
