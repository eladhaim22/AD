package entities;

import javax.persistence.*;

@Entity
@Table (name = "comandas")
public class ComandaEntity {

	public ComandaEntity() {
	}

	public ComandaEntity(Integer id, Integer cantidad, String estado, ItemCartaEntity item) {
		this.id = id;
		this.cantidad = cantidad;
		this.estado = estado;
		this.item = item;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private Integer cantidad;
	@Column
	private String estado;

	@ManyToOne
	private ItemCartaEntity item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ItemCartaEntity getItem() {
		return item;
	}

	public void setItem(ItemCartaEntity item) {
		this.item = item;
	}

}
