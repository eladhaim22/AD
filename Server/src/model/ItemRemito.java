package model;



public class ItemRemito {
	public ItemRemito(Integer itemRemitoId, int cantidad, Ingrediente ingrediente) {
		this.itemRemitoId = itemRemitoId;
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
	}

	private Integer itemRemitoId;
	private float cantidad;
	private Ingrediente ingrediente;

	public ItemRemito(float cantidad,Ingrediente ingrediente){
		this.cantidad=cantidad;
		this.ingrediente=ingrediente;
	}


    public Integer getItemRemitoId() {
		return itemRemitoId;
	}


	public void setItemRemitoId(Integer itemRemitoId) {
		this.itemRemitoId = itemRemitoId;
	}


	public float getCantidad() {
		return cantidad;
	}


	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	public Ingrediente getIngrediente() {
		return ingrediente;
	}


	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

}
