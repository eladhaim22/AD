package dto;

import java.io.Serializable;

public class IngredienteDto implements Serializable{

    private Integer ingredienteId;

    private float cantidad;

    private StockDto stock;

    private String unidadDeMedida;

    private ProductoDto productoAsociado;

    public Integer getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Integer ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public StockDto getStock() {
        return stock;
    }

    public void setStock(StockDto stock) {
        this.stock = stock;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public ProductoDto getProductoAsociado() {
        return productoAsociado;
    }

    public void setProductoAsociado(ProductoDto productoAsociado) {
        this.productoAsociado = productoAsociado;
    }
}
