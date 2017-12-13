package dominio;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@Entity
@Table(name="lote")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Lote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer loteId;
	
	private Date fecha;
	
	private Integer numero;

	public Integer getLoteId() {
		return loteId;
	}

	public void setLoteId(Integer loteId) {
		this.loteId = loteId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
