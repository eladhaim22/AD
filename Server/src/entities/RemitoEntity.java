package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Remitos")
public class RemitoEntity {

	public RemitoEntity(Date fecha, List<ItemRemitoEntity> itemsRemito) {
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer numero;
	private Date fecha;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemRemitoEntity> itemsRemito;
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<ItemRemitoEntity> getItemsRemito() {
		return itemsRemito;
	}
	public void setItemsRemito(List<ItemRemitoEntity> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	
}
