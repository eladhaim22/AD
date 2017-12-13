package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name="planDeProduccion")
public class PlanDeProduccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="planId")
	private Integer id;
	
	@OneToMany
	@JoinColumn(name="planId")	
	private List<ItemPP> items = new ArrayList<ItemPP>();
	
	private String nombre;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Sucursal sucursal;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Area area;
	
	private float objetivo;
	
	public PlanDeProduccion() 
	{
	}

	public List<ItemPP> getItems() {
		return items;
	}

	public void setItems(List<ItemPP> items) {
		this.items = items;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(float objetivo) {
		this.objetivo = objetivo;
	}
	
	
}
