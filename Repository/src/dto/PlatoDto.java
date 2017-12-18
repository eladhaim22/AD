package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlatoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer platoId;
	private String nombre;
	private String unidadMedida;
	private Float porcionesXUnidad;
	private String comentarios;
	private String rubro;
	private String receta;
	private Integer cartaId;
	private List<ItemIngredienteDTO> ingredients = new ArrayList<>();
	private Integer areaId;

	public Integer getPlatoId() {
		return platoId;
	}

	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Float getPorcionesXUnidad() {
		return porcionesXUnidad;
	}

	public void setPorcionesXUnidad(Float porcionesXUnidad) {
		this.porcionesXUnidad = porcionesXUnidad;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public String getReceta() {
		return receta;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public List<ItemIngredienteDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<ItemIngredienteDTO> ingredients) {
		this.ingredients = ingredients;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getCartaId() {
		return cartaId;
	}

	public void setCartaId(Integer cartaId) {
		this.cartaId = cartaId;
	}
}
