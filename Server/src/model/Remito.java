package model;


import java.util.Date;
import java.util.List;

public class Remito {
	public Remito(Integer numero, Date fecha, List<ItemRemito> itemsRemito) {
		this.numero = numero;
		this.fecha = fecha;
		this.itemsRemito = itemsRemito;
	}

	private Integer numero;
	private Date fecha;
	private List<ItemRemito> itemsRemito;

    public Remito() {
    	this.fecha=new Date();
    }

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
	
	public void agregarItemRemito(ItemRemito item){
		this.itemsRemito.add(item);
	}
	
}
