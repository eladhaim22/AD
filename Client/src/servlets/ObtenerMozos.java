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
import excepciones.ObtenerSectoresException;


/**
 * Servlet implementation class ObtenerMozos
 */
public class ObtenerMozos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerMozos() {
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
					"<script type=\"text/javascript\">\n" +
					"function validarForm(){\n" +
					"if (document.getElementById(\"comboMozos\").value==\"\") {\n" + 
					"alert('Debe ingresar una Mesa.');" +
					"return false;\n" +
					"}\n\n" +
					"if(document.getElementById(\"txtComensales\").value == \"\") {\n" +
					"alert('Debe ingresar una cantidad de comensales.');\n" +
					"return false;\n" +
					"}\n" +
					"document.getElementById(\"formularioMozos\").submit();\n" +
					"}\n" +
					"</script>\n" +
					"</head>\n";
			
		HTML=HTML +	"<body>\n" +
					"<div>\n" +
					"<h2>" + title + "</h2>\n" +
					"</div>\n" +
					"<form name=\"frmMozos\" id=\"formularioMozos\" method=\"GET\" action=\"GetMesasLibres\" onsubmit=\"return  validarForm()\">\n" +
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
				    "Cantidad Comensales: <input type=\"text\" id=\"txtComensales\" name=\"txtCantComensales\">\n" +
				    "<input type=\"hidden\" name=\"cbSucursal\" id=\"cbSucursal\" value=\"" + request.getParameter("cbSucursal") + "\">\n" +
				    "<input name=\"btnGetMesas\" type=\"submit\" value=\"Ver Mesas Libres\">\n" +
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
