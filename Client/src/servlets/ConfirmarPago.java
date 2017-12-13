package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import excepciones.LookupException;


/**
 * Servlet implementation class ConfirmarPago
 */
public class ConfirmarPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarPago() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Factura Pagada";	
	    
	    try {
			BusinessDelegate.getInstance().registrarPagoFactura(Integer.parseInt(request.getParameter("cbFacturaId")), request.getParameter("cbMedioPago"),Integer.parseInt(request.getParameter("cbMesaId")) );
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    String HTML="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
    	    	"<html>\n" +
				"<head>\n" +
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" + 
				"<title>" + title + "</title>\n" +
				"</head>\n"+
	    		"<body>" +
				"<h1> Se ha registrado el pago de la factura exitosamente! </h1>"+
				"<br><br><a href='MenuMozo.jsp'>volver al menu</a>\n" +
				"</body>" +
	    		"</html>";
	    
	    out.println(HTML);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
