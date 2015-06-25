package baul;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;

public class ServletRequestListener implements javax.servlet.ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent servletrequestevent) 
	{
		ServletContext servletcontext = servletrequestevent.getServletContext();
		servletcontext.setAttribute("peticiones_activas", (int)servletcontext.getAttribute("peticiones_activas")-1);
		System.out.println("ServletRequestEvent : Destruido");		
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletrequestevent) 
	{
		ServletContext servletcontext = servletrequestevent.getServletContext();
		servletcontext.setAttribute("peticiones_contador", (int)servletcontext.getAttribute("peticiones_contador")+1);
		servletcontext.setAttribute("peticiones_activas", (int)servletcontext.getAttribute("peticiones_activas")+1);
		System.out.println("ServletRequestEvent : Inicializado");		
	}

}
