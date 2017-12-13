package dominio;

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
public class Remito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer numero;
	private Date fecha;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemRemito> itemsRemito;
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
	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}
	public void setItemsRemito(List<ItemRemito> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	
}
