package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Mesas")
public class Mesa extends EntityClass {
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "capacidad")
	private int capacidad;
	
	@Column(name = "empty")
	private boolean isEmpty;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}
}
