package entities;

import javax.persistence.*;

@Entity
@Table(name="itemPP")
public class ItemPPEntity {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemPPId;
	
	@ManyToOne
	@JoinColumn(name="seminelabodadoId")
	private SemielaboradoEntity semielaborado;
	
	private Integer cantidad;
	
	private boolean finalizado_flag;
	
	public ItemPPEntity(){}
	
	public ItemPPEntity(Integer itemPPId,SemielaboradoEntity semielaborado, Integer cantidad,
						boolean finalizado_flag) {
		this.itemPPId = itemPPId;
		this.semielaborado = semielaborado;
		this.cantidad = cantidad;
		this.finalizado_flag = finalizado_flag;
	}
	
	public SemielaboradoEntity getSemielaborado() {
		return semielaborado;
	}
	public void setSemielaborado(SemielaboradoEntity semielaborado) {
		this.semielaborado = semielaborado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public boolean isFinalizado_flag() {
		return finalizado_flag;
	}
	public void setFinalizado_flag(boolean finalizado_flag) {
		this.finalizado_flag = finalizado_flag;
	}

	public Integer getItemPPId() {
		return itemPPId;
	}

	public void setItemPPId(Integer itemPPId) {
		this.itemPPId = itemPPId;
	}	

}
