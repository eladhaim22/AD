package entities;

import model.Area;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name="planDeProduccion")
public class PlanDeProduccionEntity {



	public PlanDeProduccionEntity(Integer id,List<ItemPPEntity> items, String nombre, SucursalEntity sucursal, AreaEntity area, float objetivo) {
		this.id = id;
		this.items = items;
		this.nombre = nombre;
		this.sucursal = sucursal;
		this.area = area;
		this.objetivo = objetivo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="planId")
	private Integer id;
	
	@OneToMany
	@JoinColumn(name="planId")	
	private List<ItemPPEntity> items = new ArrayList<ItemPPEntity>();
	
	private String nombre;
	
	@OneToOne (cascade = CascadeType.ALL)
	private SucursalEntity sucursal;
	
	@OneToOne (cascade = CascadeType.ALL)
	private AreaEntity area;
	
	private float objetivo;
	
	public PlanDeProduccionEntity()
	{
	}

	public List<ItemPPEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemPPEntity> items) {
		this.items = items;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}

	public AreaEntity getArea() {
		return area;
	}

	public void setArea(AreaEntity area) {
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
