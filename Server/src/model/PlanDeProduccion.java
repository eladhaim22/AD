package model;

import java.util.ArrayList;
import java.util.List;


public class PlanDeProduccion {

	public PlanDeProduccion(Integer id, List<ItemPP> items, String nombre, Sucursal sucursal, Area area, float objetivo) {
		this.id = id;
		this.items = items;
		this.nombre = nombre;
		this.sucursal = sucursal;
		this.area = area;
		this.objetivo = objetivo;
	}

	private Integer id;
	private List<ItemPP> items = new ArrayList<ItemPP>();
	private String nombre;
	private Sucursal sucursal;
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
