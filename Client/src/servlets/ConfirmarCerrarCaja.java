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
public class ConfirmarCerrarCaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarCerrarCaja() {
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
		    String title = "Cerrar Caja";
		    
		    Double diffEnCaja = null;
		    
		
		
				try {
					diffEnCaja  = BusinessDelegate.getInstance().cerrarCaja(
							Integer.parseInt(request.getParameter("cbSucursal")),Double.parseDouble(request.getParameter("txtValorCaja")));
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
									
					if(diffEnCaja !=null) {
					HTML=HTML +	"<body>\n" +
							"<div>\n" +
							"<h1> Se ha cerrado la caja exitosamente!</h1>\n" +
							"<h3> differencia entre valor facturado y valor ingresado: " + String.valueOf(diffEnCaja)  + "</h3>\n" +
							"</div>\n"+
							"<a href='MenuCaja.jsp'>Menu Caja</a>"+
							"</body>\n" +
						    "</html>";
					}
					else {
						HTML=HTML +	"<body>\n" +
								"<div>\n" +
								"<h1> La caja ya cerro y no se puede modificar!</h1>\n" +
								"</div>\n"+
								"<a href='MenuCaja.jsp'>Menu Caja</a>"+
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
