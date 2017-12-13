package dominio;

import javax.persistence.*;

@Entity
@Table (name="marcas")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer marcaId;
	
	@Column(nullable = false, length=50)
	private String nombre;
	
	@Column(nullable = false)
	private Integer nivel;
	
	@Column(nullable = false, length=100)
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
