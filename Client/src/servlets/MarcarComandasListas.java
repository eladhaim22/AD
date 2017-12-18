package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelgate.BusinessDelegate;
import Exceptions.ServiceError;
import dto.ComandaDto;
import dto.ItemIngredienteDTO;
import dto.MesaDto;
import excepciones.LookupException;
import excepciones.ObtenerSectoresException;


/**
 * Servlet implementation class GetMesasLibres
 */
public class MarcarComandasListas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcarComandasListas() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String jspPage = "/MarcarComandasListas.jsp";
        dispatch(jspPage, request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> comandaIds = new ArrayList<>();
        int count = 0;
        while(request.getParameter("comanda" + count) != null){
            if(request.getParameter("cbEstado" + String.valueOf(count)).compareTo("Finalizado") == 0){
                comandaIds.add(Integer.parseInt(request.getParameter("comanda" + String.valueOf(count))));
            }
            count++;
        }
        try {
            BusinessDelegate.getInstance().aprobarComandas(comandaIds);
        } catch (ServiceError serviceError) {
            serviceError.printStackTrace();
        }
        String jspPage = "/MenuCocina.jsp";
        dispatch(jspPage, request, response);

    }

    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

}
