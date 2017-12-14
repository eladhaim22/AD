package model;


public class IngredienteSemielaborado extends Ingrediente {

	public IngredienteSemielaborado(Integer ingredienteId, float cantidad, Stock stock, Semielaborado semielaboradoAsociado) {
		super(ingredienteId, cantidad, stock);
		this.semielaboradoAsociado = semielaboradoAsociado;
	}

	private Semielaborado semielaboradoAsociado;

	public Semielaborado getSemielaboradoAsociado() {
		return semielaboradoAsociado;
	}

	public void setSemielaboradoAsociado(Semielaborado semielaboradoAsociado) {
		this.semielaboradoAsociado = semielaboradoAsociado;
	}

}
