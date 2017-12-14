package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.MozoDto;
import excepciones.LookupException;

/**
 * Servlet implementation class ObtenerMozosFact
 */
public class ObtenerMozosFact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerMozosFact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Seleccionar Mozo";
	    
		List<MozoDto> lista = new Vector<MozoDto>();
	    

			try {
				lista  = BusinessDelegate.getInstance().obtenerMozos(Integer.parseInt(request.getParameter("cbSucursal")));
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
				"</head>\n";
		
	HTML=HTML +	"<body>\n" +
				"<div>\n" +
				"<h2>" + title + "</h2>\n" +
				"</div>\n" +
				"<form name=\"frmMozos\" id=\"formularioMozos\" method=\"GET\" action=\"MesasFacImpaga\">\n" +
				"<blockquote>\n" +
				"<h3>Nombre:\n" +
				"<select name=\"cbMozo\" id=\"comboMozos\" size=\"1\">\n";
								    
		    	for (MozoDto a : lista) {
		    		HTML=HTML + "<option value=\"" + a.getId() + "\">\n" +
			            a.getNombre() +					            
			            "</option>\n";
		    	}					    
			    
	HTML=HTML + "</select>\n" +
    			"</h3><br/>\n" +						
			    "<input type=\"hidden\" name=\"cbSucursal\" id=\"cbSucursal\" value=\"" + request.getParameter("cbSucursal") + "\">\n" +
			    "<input name=\"btnGetFact\" type=\"submit\" value=\"Ver facturas impagas\">\n" +
			    "</blockquote>\n" +					    
			    "</form>\n" +    
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
