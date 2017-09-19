package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carta extends EntityClass{
	private List<ItemCarta> itemsCarta = new ArrayList<ItemCarta>();
	private Date fechaVigencia;
}
