package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletCerrarSesion extends HttpServlet{
	
	private static final Logger logger = LogManager.getRootLogger();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession httpsesion = req.getSession(false);
		if(null==httpsesion)
		{
			logger.trace("Error al cerrar la sesion (HttpSession no existente)");
			out.println("Error al cerrar la sesion (HttpSession no existente)");
		}
		else if(null!=httpsesion)
		{
			logger.trace("Sesion finalizada "+req.getSession(false).getAttribute("nombre"));
			out.println("Sesion finalizada "+req.getSession(false).getAttribute("nombre"));
			httpsesion.invalidate();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		super.doPost(req, resp);
	}

}
