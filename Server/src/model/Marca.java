package model;



public class Marca {

	public Marca(Integer marcaId, String nombre, Integer nivel, String comentarios) {
		this.marcaId = marcaId;
		this.nombre = nombre;
		this.nivel = nivel;
		this.comentarios = comentarios;
	}

	private Integer marcaId;
	private String nombre;
	private Integer nivel;
	private String comentarios;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Integer getId() {
		return marcaId;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

}
