package dominio;

import javax.persistence.*;

@Entity
@Table (name = "itemsCarta")
public class ItemCarta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemCartaId;
	
	@Column(nullable=false)
	private float precio;
	
	@ManyToOne
	@JoinColumn(name="platoId")
	private Plato platoAsociado;
	
	@Column(nullable=false)
	private float adicionalComision;


	public Integer getItemCartaId() {
		return itemCartaId;
	}

	public void setItemCartaId(Integer itemCartaId) {
		this.itemCartaId = itemCartaId;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Plato getPlatoAsociado() {
		return platoAsociado;
	}

	public void setPlatoAsociado(Plato platoAsociado) {
		this.platoAsociado = platoAsociado;
	}

	public float getAdicionalComision() {
		return adicionalComision;
	}

	public void setAdicionalComision(float adicionalComision) {
		this.adicionalComision = adicionalComision;
	}

}
