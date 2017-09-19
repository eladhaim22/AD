package dominio;

import java.util.ArrayList;
import java.util.List;

public class DepositoCentral extends EntityClass{
	private Stock stock;
	private List<OrdenCompra> ordensDeCompra = new ArrayList<OrdenCompra>();
}
