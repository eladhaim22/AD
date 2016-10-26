package holamundo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.Naming;
import java.rmi.RemoteException;

import dto.TestDto;
import remoto.ITestService;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITestService test;
	public boolean getStub() {
    	
    	try {
    		System.setProperty("java.security.policy","C:\\Projects\\AD\\security\\rmi.policy");
    		if(System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
			test = (ITestService)Naming.lookup ("//localhost/Test");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public HolaMundo() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
    	if(getStub()) 
    	{
    		try {
    			test.envioTest(new TestDto("asdfasdf"));
    		} catch (RemoteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	} 
	    /*if(getRemoteService() != null){
		    out.println("<html>");
		    out.println("<body>");
		    out.println("<h1>Hola Mundo</h1;>");
		    out.println("</body>");
		    out.println("</html>");
	    }*/
	  }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
