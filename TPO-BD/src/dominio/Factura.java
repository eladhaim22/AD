package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura extends EntityClass {
	private Date FechaDePago;
	private Date FechaDeCierre;
	private MedioPago medioPago;
	private Mozo mozo;
	private Mesa mesa;
	private List<ItemFactura> itemsFactura = new ArrayList<ItemFactura>();
}
