package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.CartaDto;
import excepciones.LookupException;
import excepciones.ObtenerCartasPorSucursalException;
import excepciones.ObtenerMesasAbiertaPorSucursalException;

/**
 * Servlet implementation class CartasPorSucursal
 */
public class CartasPorSucursal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/xml";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartasPorSucursal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		String sucursalId = request.getParameter("sucursalId");
		
		List<CartaDto> cartas = null;
		if (sucursalId != null) {
			try {
				cartas = BusinessDelegate.getInstance().obtenerCartasPorSucursal(Integer.parseInt(sucursalId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (cartas.size() > 0) {

				PrintWriter out = response.getWriter();
				out.println("<?xml version=\"1.0\"?>");
				out.println("<cartas>");
				for (Iterator<CartaDto> iter = cartas.iterator(); iter.hasNext(); ) {
					CartaDto m = iter.next();
					out.println("<carta id=\"" + m.getCartaId().toString() + "\" >" +	m.getNombre() + "</carta>");
				}
				out.println("</cartas>");
				return;
			}
		}
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
