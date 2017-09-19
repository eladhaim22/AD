package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cocina extends EntityClass {
	private Sucursal sucursal;
	private List<ProductosEstimados> productosEstimados = new ArrayList<ProductosEstimados>();
	private PlanProduccion planDeProduccion;
}
