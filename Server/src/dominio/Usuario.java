package dominio;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="categoria", discriminatorType=DiscriminatorType.STRING)
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Integer nroUsuario;
	
	protected String nombre;
	
	protected abstract String obtenerTipo();
	
	public Integer getNroUsuario() {
		return nroUsuario;
	}

	public void setNroUsuario(Integer nroUsuario) {
		this.nroUsuario = nroUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
