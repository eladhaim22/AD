package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanProduccion extends EntityClass {
	private String estado;
	private List<ItemPlanProduccion> items = new ArrayList<ItemPlanProduccion>();
	private Date fecha;
}
