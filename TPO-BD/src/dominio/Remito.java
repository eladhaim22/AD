package dominio;

import java.util.Date;

public class Remito {
	private int numero;
	private Manifiesto manifiesto;
	private Envio envio;
	private Date fechaEstimadaEntrega;
	private Date fechaMaximaEntrega;
	private String condicionesTratamiento;
	private String infoAdicional;
	private Cliente cliente;
	public Date calcularFechaEstimada() {
		return new Date();
	}
}