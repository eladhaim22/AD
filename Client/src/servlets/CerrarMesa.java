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
import dto.MesaDto;
import excepciones.LookupException;
import excepciones.ObtenerMesasACerrarException;
import excepciones.ObtenerMesasAbiertaPorSucursalException;
import excepciones.ObtenerSectoresException;

/**
 * Servlet implementation class CerrarMesa
 */
public class CerrarMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarMesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Seleccionar Mesa a cerrar";	
	    
	    List<MesaDto> lista = new Vector<MesaDto>();
	    
	    try {
			lista = BusinessDelegate.getInstance().obtenerMesasAbiertaPorSucursal(Integer.parseInt(request.getParameter("cbSucursal")));
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
		
	HTML=HTML +	"<body>\n" +
				"<div>\n" +
				"<h2>" + title + "</h2>\n" +
				"</div>\n" +
				"<form name=\"frmAbrirM\" id=\"frmAbrirMesa\" method=\"GET\" action=\"ConfirmarCerrarMesa\">\n" +
				"<blockquote>\n" +
				"<h3>Mesa:\n" +
				"<select name=\"cbMesa\" id=\"comboMesasDisponibles\" size=\"1\">\n";
								    
		    	for (MesaDto a : lista) {
		    		HTML=HTML + "<option value=\"" + a.getId() + "\">\n" +
			            a.getNumero() +					            
			            "</option>\n";
		    	}					    
			    
	HTML=HTML + "</select>\n" +
    			"</h3><br/>\n" +						
			    "<input name=\"btnCerrarMesa\" type=\"submit\" value=\"Cerrar Mesa\">\n" +
			    "</blockquote>\n" +					    
			    "</form>\n" +    
			    "</body>\n" +
			    "</html>";
			    
		out.println(HTML);
		
	}

}
