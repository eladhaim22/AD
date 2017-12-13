package dominio;

import javax.persistence.*;


@Entity
@DiscriminatorValue("IS")
public class Ingrediente_Semielaborado extends Ingrediente{
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seminelabodadoId")
	private Semielaborado semielaboradoAsociado;

	public Semielaborado getSemielaboradoAsociado() {
		return semielaboradoAsociado;
	}

	public void setSemielaboradoAsociado(Semielaborado semielaboradoAsociado) {
		this.semielaboradoAsociado = semielaboradoAsociado;
	}

}
