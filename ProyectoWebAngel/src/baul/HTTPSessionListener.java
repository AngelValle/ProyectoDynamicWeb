package baul;

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
		logger.trace("Session ID: "+arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) 
	{
		logger.trace("HTTPSessionListener : Destruido");
		logger.trace("Session ID: "+arg0.getSession().getId());
	}

}
