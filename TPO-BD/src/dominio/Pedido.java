package dominio;

import java.util.ArrayList;
import java.util.List;

public class Pedido extends EntityClass {
	private Mesa mesa;
	private List<Item> items = new ArrayList<Item>();
	
}
