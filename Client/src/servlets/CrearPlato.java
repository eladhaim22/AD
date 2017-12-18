package servlets;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.ItemCartaDto;
import dto.ItemIngredienteDTO;
import dto.PlatoDto;
import sun.net.www.content.text.PlainTextInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CargarPedido
 */
public class CrearPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPlato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jspPage = "/CrearPlatoGetCarta.jsp";
		dispatch(jspPage, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlatoDto plato = new PlatoDto();
		plato.setNombre(request.getParameter("nombre"));
		plato.setRubro(request.getParameter("rubro"));
		plato.setUnidadMedida(request.getParameter("unidadMedida"));
		plato.setPorcionesXUnidad(Float.parseFloat(request.getParameter("porcionesXUnidad")));
		plato.setReceta(request.getParameter("receta"));
		plato.setComentarios(request.getParameter("comentarios"));
		plato.setAreaId(Integer.parseInt(request.getParameter("areaId")));
		int count = 0;
		while(request.getParameter("hddRow" + count) != null){
			plato.getIngredients().add(new ItemIngredienteDTO(null,Float.parseFloat(request.getParameter("txtRow" + count)),Integer.parseInt(request.getParameter("hddRow" + count))));
		count++;
		}
		try {
			BusinessDelegate.getInstance().crearPlato(plato);
		} catch (ServiceError serviceError) {
			serviceError.printStackTrace();
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Confirmar crear plato";

		String HTML = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
				"<html>\n" +
				"<head>\n" +
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
				"<title></title>\n" +
				"</head>\n" +
				"<body>\n" +
				"	<p style=\"color: red;\">Se ha generado el plato exitosamente</p>\n" +
				"   <br><br><a href='MenuCocina.jsp'>volver al menu</a>\n" +
				"</body>\n" +
				"</html>";

		PrintWriter out2 = response.getWriter();
		out2.println(HTML);
	}
	
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

}
