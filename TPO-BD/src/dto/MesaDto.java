package dto;


public class MesaDto {
	private String numero;
	private String capacidad;
	private Long mozoId;
	private boolean isEmpty;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public Long getMozoId() {
		return mozoId;
	}

	public void setMozoId(Long mozoId) {
		this.mozoId = mozoId;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}
}
