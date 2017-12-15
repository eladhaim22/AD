package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.FacturaDto;
import excepciones.LookupException;

/**
 * Servlet implementation class ConfirmarCerrarMesa
 */
public class ConfirmarCerrarMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarCerrarMesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Confirmar cerrar Mesa";	
	    
	    FacturaDto factura = new FacturaDto();
	    
	    
	    String HTML="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
    	    	"<html>\n" +
				"<head>\n" +
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" + 
				"<title>" + title + "</title>\n" +
				"</head>\n";
		
	
			try {
				BusinessDelegate.getInstance().cerrarMesa(Integer.parseInt(request.getParameter("cbMesa")));
				BusinessDelegate.getInstance().generarFactura(Integer.parseInt(request.getParameter("cbMesa")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String HTML2 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
					"<html>\n" +
					"<head>\n" +
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
					"<title></title>\n" +
					"</head>\n" +
					"<body>\n" +
					"	<p style=\"color: red;\">Se ha generado la factura exitosamente</p>\n" +
					"   <br><br><a href='MenuMozo.jsp'>volver al menu</a>\n" +
					"</body>\n" +
					"</html>";
			
			PrintWriter out2 = response.getWriter();
			out2.println(HTML2);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
