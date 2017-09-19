package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AsientoContable extends EntityClass {
	private List<Factura> facturas = new ArrayList<Factura>();
	private Date Fecha;
	private boolean esActivo;
}
