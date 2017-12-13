package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.MozoDto;
import excepciones.LookupException;
import excepciones.ObtenerSectoresException;


/**
 * Servlet implementation class ObtenerMozos
 */
public class CalcularComisiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcularComisiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 	response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String title = "Listar Comisiones";
		    
		    Map<String,Double> lista = new HashMap<String,Double>();
		    
		
		
				try {
					lista  = BusinessDelegate.getInstance().calcularComissionEnSucursal(Integer.parseInt(request.getParameter("cbSucursal")));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		 String HTML= "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
	    	    	"<html>\n" +
					"<head>\n" +
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" + 
					"<title>" + title + "</title>\n" +
					"</head>\n";
			
		   
		    
		HTML= HTML + "<body>\n" +
					"<div>\n" +
					"<h2>" + title + "</h2>\n" +
					"</div>\n" +
					"<table>\n" +
						"<tr>\n" + 
							"<th>Nombre</th><th>Comision</th>\n" +
						"</tr>\n";
		
			    	for (String nombre : lista.keySet()) {
			    		HTML=HTML + "<tr><td>" + nombre + "</td><td>" + lista.get(nombre).intValue() + " $</td></tr>\n";
			    	}
			    	
			    	HTML=HTML + "</table>\n" +
			    				
			    				"<br><br><a href='MenuCaja.jsp'>Menu Caja</a>"+
							    "</body>\n" +
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
