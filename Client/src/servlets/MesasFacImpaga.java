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



/**
 * Servlet implementation class MesasFacImpaga
 */
public class MesasFacImpaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesasFacImpaga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Seleccionar Mesa";	
	    
	    List<MesaDto> lista = new Vector<MesaDto>();
	    
	    try {
			lista = BusinessDelegate.getInstance().getMesasImpagas(Integer.parseInt(request.getParameter("cbSucursal")), Integer.parseInt(request.getParameter("cbMozo")));
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
				"<form name=\"frmMesaImpaga\" id=\"frmMsaImpaga\" method=\"GET\" action=\"GetFacturaMesa\">\n" +
				"<blockquote>\n" +
				"<h3>Mesa:\n" +
				"<select name=\"cbMesa\" id=\"comboMesasDisponibles\" size=\"1\">\n";
								    
		    	for (MesaDto a : lista) {
		    		HTML=HTML + "<option value=\"" + a.getId().toString() + "\">\n" +
			            a.getNumero() +					            
			            "</option>\n";
		    	}					    
			    
		    HTML=HTML + "</select>\n" +
    			"</h3><br/>\n" +						
			    "<input type=\"hidden\" name=\"cbCantComensales\" id=\"cbComensales\" value=\"" + request.getParameter("txtCantComensales") + "\">\n" +
			    "<input name=\"btnVerFactura\" type=\"submit\" value=\"Ver factura\">\n" +
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
