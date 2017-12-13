package dominio;

import javax.persistence.*;

@Entity
@Table(name="itemPP")
public class ItemPP {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemPPId;
	
	@ManyToOne
	@JoinColumn(name="seminelabodadoId")
	private Semielaborado semielaborado;
	
	private Integer cantidad;
	
	private boolean finalizado_flag;
	
	public ItemPP(){}
	
	public ItemPP(Semielaborado semielaborado, Integer cantidad,
			boolean finalizado_flag) {
		this.semielaborado = semielaborado;
		this.cantidad = cantidad;
		this.finalizado_flag = finalizado_flag;
	}
	
	public Semielaborado getSemielaborado() {
		return semielaborado;
	}
	public void setSemielaborado(Semielaborado semielaborado) {
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
