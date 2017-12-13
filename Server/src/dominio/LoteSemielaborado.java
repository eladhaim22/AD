package dominio;

import javax.persistence.*;

@Entity
@Table(name="loteSemielaborado")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="loteId")
public class LoteSemielaborado extends Lote{

	@ManyToOne
	@JoinColumn(name="seminelabodadoId")	
	private Semielaborado semielaborado;

	public Semielaborado getSemielaborado() {
		return semielaborado;
	}

	public void setSemielaborado(Semielaborado semielaborado) {
		this.semielaborado = semielaborado;
	}
}
