package entities;

import javax.persistence.*;

@Entity
@Table(name = "mozos")
public class MozoEntity {
	public MozoEntity() {
	}

	public MozoEntity(int id, String nombre, float porcComision) {
		this.id = id;
		this.nombre = nombre;
		this.porcComision = porcComision;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name ="nombre")
	private String nombre;

	@Column (name="porc_Comision", nullable = true)
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

}
