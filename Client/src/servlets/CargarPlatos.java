package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.ComandaDto;
import dto.ItemCartaDto;
import excepciones.AgregarItemPedidoException;
import excepciones.LookupException;
import excepciones.ObtenerPedidoException;

import vo.*;

/**
 * Servlet implementation class CargarPlatos
 */
public class CargarPlatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CargarPlatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemsIds = request.getParameter("hddItemsIds");
		String cantidades = request.getParameter("hddItemsCants");
		int pedidoId = Integer.parseInt(request.getParameter("hddPedidoId"));

		List<ComandaDto> listItems = new ArrayList<ComandaDto>();
		for (int i = 0; i < itemsIds.split(",").length; i++) {
			ItemCartaDto vo = new ItemCartaDto();
			ComandaDto voPedido = new ComandaDto();

			ItemCartaDto ic;
			try {
				ic = BusinessDelegate.getInstance().obtenerItemCartaById(Integer.parseInt(itemsIds.split(",")[i]));
				voPedido.setItem(ic);
				voPedido.setCantidad(Integer.parseInt(cantidades.split(",")[i]));
				listItems.add(voPedido);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			BusinessDelegate.getInstance().agregarComanda(pedidoId, listItems);
		} catch (ServiceError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String HTML = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
				+ "<html>\n" + "<head>\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
				+ "<title></title>\n" + "</head>\n" + "<body>\n"
				+ "	<p style=\"color: red;\">Se ha ingresado exitosamente los items al pedido: "
				+ String.valueOf(pedidoId) + "</p>\n" + "   <br><br><a href='MenuMozo.jsp'>volver al menu</a>\n"
				+ "</body>\n" + "</html>";

		PrintWriter out = response.getWriter();
		out.println(HTML);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
