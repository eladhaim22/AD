package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.MesaDto;
import excepciones.LookupException;
import excepciones.ObtenerMesasAbiertaPorSucursalException;


import vo.MesaVO;

/**
 * Servlet implementation class MesasAbiertaPorSucursal
 */
public class MesasAbiertaPorSucursal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/xml";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesasAbiertaPorSucursal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		String sucursalId = request.getParameter("sucursalId");
		
		List<MesaDto> mesas = null;
		if (sucursalId != null) {
			try {
				mesas = BusinessDelegate.getInstance().obtenerMesasAbiertaPorSucursal(Integer.parseInt(sucursalId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (mesas.size() > 0) {

				PrintWriter out = response.getWriter();
				out.println("<?xml version=\"1.0\"?>");
				out.println("<mesas>");
				for (Iterator<MesaDto> iter = mesas.iterator(); iter.hasNext(); ) {
					MesaDto m = iter.next();
					out.println("<mesa id=\"" + m.getId().toString() + "\" >" +	m.getNumero() + "</mesa>");
				}
				out.println("</mesas>");
				return;
			}
		}
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
