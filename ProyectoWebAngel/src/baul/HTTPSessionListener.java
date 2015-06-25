package baul;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HTTPSessionListener implements HttpSessionListener {

	private final Logger logger = LogManager.getRootLogger();
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) 
	{
		logger.trace("HTTPSessionListener : Inicializado");
		
		ServletContext servletcontext = arg0.getSession().getServletContext();
		
		@SuppressWarnings("unchecked")
		Map<String, HttpSession> map_sesiones = (Map<String, HttpSession>)servletcontext.getAttribute("map_sesiones");
		logger.trace("map_sesiones recogido de ServletContext con exito.");
		
		map_sesiones.put(arg0.getSession().getId(), arg0.getSession());
		logger.trace("Sesion insertado en map_sesiones con exito.");
		
//		servletcontext.setAttribute("map_sesiones", map_sesiones);
//		logger.trace("map_sesiones insertado en ServletContext con exito.");

		logger.trace("Session ID: "+arg0.getSession().getId());
		
		logger.trace("Sesiones activas: "+map_sesiones.size());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) 
	{
		logger.trace("HTTPSessionListener : Destruido");
		
		ServletContext servletcontext = arg0.getSession().getServletContext();
		
		@SuppressWarnings("unchecked")
		Map<String, HttpSession> map_sesiones = (Map<String, HttpSession>)servletcontext.getAttribute("map_sesiones");
		logger.trace("map_sesiones recogido de ServletContext con exito.");
		
		map_sesiones.remove(arg0.getSession().getAttribute("nombre").toString());
		logger.trace("Sesion borrada de map_sesiones con exito.");
		
//		servletcontext.setAttribute("map_sesiones", map_sesiones);
//		logger.trace("map_sesiones insertado en ServletContext con exito.");
		
		logger.trace("Session ID: "+arg0.getSession().getId());
	}

}
