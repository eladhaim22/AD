package entities;

import javax.persistence.*;

@Entity
@Table (name = "itemsCarta")
public class ItemCartaEntity {

	public ItemCartaEntity() {
	}

	public ItemCartaEntity(int itemCartaId, float precio, PlatoEntity platoAsociado, float adicionalComision) {
		this.itemCartaId = itemCartaId;
		this.precio = precio;
		this.platoAsociado = platoAsociado;
		this.adicionalComision = adicionalComision;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemCartaId;
	
	@Column(nullable=false)
	private float precio;
	
	@ManyToOne
	@JoinColumn(name="platoId")
	private PlatoEntity platoAsociado;
	
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

	public PlatoEntity getPlatoAsociado() {
		return platoAsociado;
	}

	public void setPlatoAsociado(PlatoEntity platoAsociado) {
		this.platoAsociado = platoAsociado;
	}

	public float getAdicionalComision() {
		return adicionalComision;
	}

	public void setAdicionalComision(float adicionalComision) {
		this.adicionalComision = adicionalComision;
	}

}
