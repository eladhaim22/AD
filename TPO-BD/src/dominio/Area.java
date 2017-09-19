package dominio;

import java.util.ArrayList;
import java.util.List;

public class Area extends EntityClass {
	private List<Comanda> comandas = new ArrayList<Comanda>();
	private Deposito deposito;
}
