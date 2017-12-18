package model;

import daos.LiquidacionDao;
import dto.LiquidacionDto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Liquidacion {

	public Liquidacion(Integer id, Mozo usuario, Date fecha, Double value) {
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.value = value;
	}

	private Integer id;
	private Mozo usuario;
	private Date fecha;
	private Double value;

	public Liquidacion(Mozo usuario,Double value){
		Instant instant = Instant.now().truncatedTo(ChronoUnit.DAYS);
		this.fecha=Date.from(instant);
		this.value=value;
		this.usuario=usuario;
	}

	public Liquidacion() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mozo getUsuario() {
		return usuario;
	}

	public void setUsuario(Mozo usuario) {
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

	public void save(){
		LiquidacionDao.getDao().save(this);
	}

	public void update(){
		LiquidacionDao.getDao().update(this);
	}

	public Liquidacion calcularLiqidacion(Mozo mozo, List<Pedido> pedidos) {
		Double comision = 0.0;
		for(Pedido p : pedidos) {
			comision+=p.getComandas().stream().filter(item -> item.getItem().getPlatoAsociado().
					getRubro().compareTo("cafeteria") != 0)
					.mapToDouble(pr ->
							mozo.calcularComision(pr.calcularMontoComanda(),
									pr.getItem().getAdicionalComision())).sum();
		}
		this.value = comision;
		if(this.id == null) {
			this.usuario = mozo;
			this.fecha = Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS));
			this.save();
		}
		else {
			this.update();
		}
		return LiquidacionDao.getDao().obtenerLiquidacionDeLaFecha(mozo.getId());
	}

	public LiquidacionDto toDto(){
		return new LiquidacionDto(this.id,this.usuario.toDto(),this.getFecha(),this.getValue());
	}
}
