package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda extends EntityClass {
	private List<ItemComanda> itemsComanda = new ArrayList<ItemComanda>();
	private Mesa mesa;
	private Date fecha;
	private String estado;
}
