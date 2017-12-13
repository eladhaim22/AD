package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="deposito")
public class Deposito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer depositoId;
	
	private String nombre;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="depositoId")
	private List<ItemDeposito> items = new ArrayList<ItemDeposito>();

	public Integer getDepositoId() {
		return depositoId;
	}

	public void setDepositoId(Integer depositoId) {
		this.depositoId = depositoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ItemDeposito> getItems() {
		return items;
	}

	public void setItems(List<ItemDeposito> items) {
		this.items = items;
	}

}
