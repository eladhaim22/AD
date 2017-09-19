package dominio;

import java.util.ArrayList;
import java.util.List;

public class Sucursal extends EntityClass {
	private String nombre;
	private Addres direccion;
	private Salon salon;
	private Cocina cocina;
	private Carta carta;
	private Caja caja;
	private Area area;
	private Administracion administracion;
	private Deposito deposito;
	private List<Mozo> mozos = new ArrayList<Mozo>();
	
}
