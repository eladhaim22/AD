package entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("IS")
public class IngredienteSemielaboradoEntity extends IngredienteEntity {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seminelabodadoId")
	private SemielaboradoEntity semielaboradoAsociado;

	public IngredienteSemielaboradoEntity(int ingredienteId, float cantidad, StockEntity stock, SemielaboradoEntity semielaboradoAsociado) {
		super(ingredienteId, cantidad, stock);
		this.semielaboradoAsociado = semielaboradoAsociado;
	}

	public SemielaboradoEntity getSemielaboradoAsociado() {
		return semielaboradoAsociado;
	}

	public void setSemielaboradoAsociado(SemielaboradoEntity semielaboradoAsociado) {
		this.semielaboradoAsociado = semielaboradoAsociado;
	}

}
