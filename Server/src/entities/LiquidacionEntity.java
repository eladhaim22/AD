package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="liquidaciones")
public class LiquidacionEntity {

	public LiquidacionEntity(int id,MozoEntity usuario, Date fecha, Double value) {
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.value = value;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private MozoEntity usuario;
	
	private Date fecha;
	
	private Double value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MozoEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(MozoEntity usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
