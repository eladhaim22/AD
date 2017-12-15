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


/**
 * Servlet implementation class GetFacturaMesa
 */
public class GetFacturaMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFacturaMesa() {
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
	    
	    FacturaDto factura = new FacturaDto();
	  
	    try {
			factura = BusinessDelegate.getInstance().getDatosFactura(Integer.parseInt(request.getParameter("cbMesa")));
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
				"<form name=\"frmMozos\" id=\"formularioMozos\" method=\"GET\" action=\"ConfirmarPago\" >\n" +
				"<h1> Datos de la factura</h1>\n" +
				"<h3> Numero factura: " + String.valueOf(factura.getNumeroFactura().intValue())  + "</h3>\n" +
				"<h3> Fecha: " + String.valueOf(factura.getFecha())  + "</h3>\n" +
				"<h3> Monto a pagar: " + String.valueOf(factura.getMonto())  + "</h3>\n" +
				"<h3> Medio de Pago: </h3>"+
				"<select name=\"cbMedioPago\" id=\"comboMediosPago\" size=\"1\" >"+           		
				"<option value=\"Efectivo\">Efectivo</option>"+
				"<option value=\"Debito\">Debito</option>"+
				"<option value=\"Tarjeta\">Tarjeta</option>"+
				"</select>\n\n"+
				
				"</div>\n"+
				"<input type=\"hidden\" name=\"cbMesaId\" id=\"cbMesa\" value=\"" + request.getParameter("cbMesa") + "\">\n" +
				"<input type=\"hidden\" name=\"cbFacturaId\" id=\"cbFac\" value=\"" + factura.getNumeroFactura() + "\">\n" +
				"<input name=\"btnGetMesas\" type=\"submit\" value=\"Pagar Factura\">\n" +
				"</form>"+
				"\n\n<a href='menu.jsp'>Menu Principal</a>"+
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
