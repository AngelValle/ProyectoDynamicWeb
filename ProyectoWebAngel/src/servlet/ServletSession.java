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

public class ServletSession extends HttpServlet{
	
	private static final Logger logger = LogManager.getRootLogger();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String nombre	= req.getParameter("nombreempleado");
		HttpSession httpsesion = req.getSession(false);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(httpsesion==null)
		{
			logger.trace("Peticion sin sesion asiganada");
			httpsesion = req.getSession(true);
			httpsesion.setAttribute("nombre", nombre);
		}
		if(httpsesion!=null)
		{
			logger.trace("Peticion con sesion asiganada");
		}
		out.println("Bienvenido "+httpsesion.getAttribute("nombre"));
		out.println("<meta http-equiv=\"refresh\" content=8; url=login.html\">");
		out.println("<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table><br><br><table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><form action=\"ServletCerrarSesion\" method=\"get\"><input type=\"submit\" value=\"Cerrar sesion\"></form></td></tr></table>");
	}

}
