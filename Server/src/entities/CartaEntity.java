package entities;

import java.util.*;

import javax.persistence.*;


@Entity
@Table (name="cartas")
public class CartaEntity {
	public CartaEntity(int cartaId,String nombre, Date fechaInicio, Date fechaFinal, boolean activo, Set<ItemCartaEntity> items) {
		this.cartaId = cartaId;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.activo = activo;
		this.items = items;
	}

	@Id
	@GeneratedValue(strategy=	GenerationType.AUTO)
	private Integer cartaId;
	
	@Column(nullable = false, length=50)
	private String nombre;
	
	@Column(nullable = false)
	private Date fechaInicio;
	
	private Date fechaFinal;
	
	@Column(nullable = false)
	private boolean activo;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cartaId")
	private Set <ItemCartaEntity> items = new HashSet<ItemCartaEntity>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio2) {
		this.fechaInicio = fechaInicio2;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<ItemCartaEntity> getItems() {
		return items;
	}

	public void setItems(Set<ItemCartaEntity> items) {
		this.items = items;
	}

	public void agregarItem(ItemCartaEntity newItem){
		items.add(newItem);
	}

	public Integer getCartaId() {
		return cartaId;
	}

	public void setCartaId(Integer cartaId) {
		this.cartaId = cartaId;
	}
	
}
