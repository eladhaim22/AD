package model;

import dto.MozoDto;


public class Mozo {

	public Mozo(Integer id, String nombre, float porcComision) {
		this.id = id;
		this.nombre = nombre;
		this.porcComision = porcComision;
	}

	private Integer id;
	private String nombre;
	private float porcComision;
	
	public float getPorcComision() {
		return porcComision;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPorcComision(float porcComision) {
		this.porcComision = porcComision;
	}

	public double calcularComision(float monto, float porcExtra)
	{
		return (monto * (this.porcComision + porcExtra) / 100); 
	}

	public MozoDto toDto(){
		MozoDto MozoDto = new MozoDto();
		MozoDto.setId(this.getId());
		MozoDto.setNombre(this.getNombre());
		MozoDto.setPorcComision(this.getPorcComision());
		MozoDto.setTipo("Mozo");
		return MozoDto;
	}

}
