package dominio;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")
public class Mozo extends Usuario{

	@Column (name="porc_Comision", nullable = true)
	private float porcComision;
	
	public float getPorcComision() {
		return porcComision;
	}

	public void setPorcComision(float porcComision) {
		this.porcComision = porcComision;
	}

	public double calcularComision(float monto, float porcExtra)
	{
		return (monto * (this.porcComision + porcExtra) / 100); 
	}

	@Override
	protected String obtenerTipo() {

		return TipoUsuario.M.toString();
	}
}
