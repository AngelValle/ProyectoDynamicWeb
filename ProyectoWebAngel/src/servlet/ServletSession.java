package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletSession extends HttpServlet{
	
	private static final Logger logger = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession httpsesion = req.getSession(false);
		
		if(httpsesion==null)
		{
			logger.trace("Peticion sin sesion asiganada");
			httpsesion = req.getSession(true);
		}
		if(httpsesion!=null)
		{
			logger.trace("Peticion con sesion asiganada");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		super.doPost(req, resp);
	}

}
