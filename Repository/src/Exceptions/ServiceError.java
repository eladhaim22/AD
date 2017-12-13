package Exceptions;

public class ServiceError extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceError(String mensaje) {
       super(mensaje, new Throwable("service error"));
    }
	
	public ServiceError(String mensaje,String throwable) {
	   super(mensaje, new Throwable(throwable));
	}
}
