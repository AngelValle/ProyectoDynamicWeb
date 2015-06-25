package baul;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletRequestListener implements javax.servlet.ServletRequestListener{

	private final Logger logger = LogManager.getRootLogger();

	
	@Override
	public void requestDestroyed(ServletRequestEvent servletrequestevent) 
	{
		ServletContext servletcontext = servletrequestevent.getServletContext();
		servletcontext.setAttribute("peticiones_activas", (int)servletcontext.getAttribute("peticiones_activas")-1);
		logger.trace("ServletRequestEvent : Destruido");		
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletrequestevent) 
	{
		ServletContext servletcontext = servletrequestevent.getServletContext();
		servletcontext.setAttribute("peticiones_contador", (int)servletcontext.getAttribute("peticiones_contador")+1);
		servletcontext.setAttribute("peticiones_activas", (int)servletcontext.getAttribute("peticiones_activas")+1);
		logger.trace("ServletRequestEvent : Inicializado");		
	}

}
