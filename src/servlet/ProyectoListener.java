package servlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.DetalleBoletaDTO;

/**
 * Application Lifecycle Listener implementation class ProyectoListener
 *
 */
@WebListener
public class ProyectoListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ProyectoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("==================================");
    	System.out.println("Empazando a escuchar la sesión");
    	System.out.println("==================================");
    	System.out.println("Id de sesion: ...............: " + arg0.getSession().getId());
		System.out.println("Fecha y hora de creación ....: " + new SimpleDateFormat().format(arg0.getSession().getCreationTime()));
		System.out.println("Tiempo máximo inactividad ...: " + arg0.getSession().getMaxInactiveInterval());
		
		// Variables globales
		
		ArrayList<DetalleBoletaDTO> carro = new ArrayList<DetalleBoletaDTO>();
		double subTotalVenta = 0.0;
		int cantArticulos = 0;
		
		//mandamos nuestros atributos a nivel de sesión.
		
		arg0.getSession().setAttribute("carro", carro);
		arg0.getSession().setAttribute("subTotalVenta", subTotalVenta);
		arg0.getSession().setAttribute("cantArticulos", cantArticulos);		
		
    }
    

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("==================================");
    	System.out.println("Dejando de escuchar la sesión");
    	System.out.println("==================================");
    	System.out.println("Id de sesion : ...............: " + arg0.getSession().getId());
		System.out.println("Último acceso: ...............: " + new SimpleDateFormat().format(arg0.getSession().getLastAccessedTime()));
		
    }
	
}
