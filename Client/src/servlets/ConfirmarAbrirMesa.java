package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.PedidoDto;
import excepciones.LookupException;
import excepciones.ObtenerSectoresException;


/**
 * Servlet implementation class ConfirmarAbrirMesa
 */
public class ConfirmarAbrirMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarAbrirMesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Confirmar apertura Mesa";	
	    
	    PedidoDto nuevoPedido = new PedidoDto();
	    
	    
	    String HTML="<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\n" +
    	    	"pageEncoding=\"ISO-8859-1\"%>" +
    	    	"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
    	    	"<html>\n" +
				"<head>\n" +
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" + 
				"<title>" + title + "</title>\n" +
				"</head>\n";
		
	
			try {
				nuevoPedido = BusinessDelegate.getInstance().confirmarAperturaMesa(Integer.parseInt(request.getParameter("cbMesa")),Integer.parseInt(request.getParameter("cbCantComensales")),
						Integer.parseInt(request.getParameter("cbMozo")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		if(nuevoPedido ==null){
			
			HTML=HTML +	"<body>\n" +
					"<div>\n" +
					"<h2> No se ha podido Abrir la mesa</h2>\n" +
					"</div>\n"+
					"</body>\n" +
				    "</html>";
		}else{
			
			
			HTML=HTML +	"<body>\n" +
					"<div>\n" +
					"<h1> Se ha abierto la mesa exitosamente!</h1>\n" +
					"<h3> Numero pedido: " + String.valueOf(nuevoPedido.getNumeroPedido())  + "</h3>\n" +
					"<h3> fecha Apertura: " + String.valueOf(nuevoPedido.getFechaApertura())  + "</h3>\n" +
					"<h3> cantidad comensales: " + String.valueOf(nuevoPedido.getCantComensales())  + "</h3>\n" +
					"</div>\n"+
					"<a href='MenuMozo.jsp'>Menu Principal</a>"+
					"</body>\n" +
				    "</html>";
		}
		
		
		out.println(HTML);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
