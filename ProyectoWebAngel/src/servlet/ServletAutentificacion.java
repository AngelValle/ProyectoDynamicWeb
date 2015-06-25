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
import org.hibernate.Session;

import clases.Users;

import conexiones.SessionManager;
import dao.SuperDAO;

public class ServletAutentificacion extends HttpServlet{
	
	private static final Logger logger = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String nombre	= req.getParameter("nombreempleado");
		String clave	= req.getParameter("claveempleado");
		
		SuperDAO superdao = new SuperDAO();	
		Session s_sesion = SessionManager.obtenerSesionNueva();
		superdao.setSesion(s_sesion);
		
		Users usuario = null;
		usuario = (Users)superdao.getSesion().createSQLQuery("SELECT * FROM USERS WHERE USER_NAME='"+nombre+"' AND USER_PASS='"+clave+"'").addEntity(Users.class).uniqueResult();
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// DECIDIMOS QUE VAMOS A HACER CON EL USUARIO
		
		// SI EL USUARIO NO EXISTE.....
		if(usuario==null)
		{
			out.println("<meta http-equiv=\"refresh\" content=\"8; url=login.html\">");
			out.println("Usuario no encontrado, por favor, registrese antes.<br>Usted sera redirigido automaticamente a Login.html.<br>Si no se redirige automaticamente puede hacerlo manualmente");
			out.println("<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table><br><br><table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"login.html\">Login</a></td></tr></table>");
			
		}
		
		else if (!usuario.getUserName().equals(nombre) || !usuario.getUserPass().equals(clave)) 
		{
			out.println("<meta http-equiv=\"refresh\" content=\"8; url=login.html\">");
			out.println("Usuario o contraseña erronea, por favor, vuelva a logearse.<br>Usted sera redirigido automaticamente a Login.html.<br>Si no se redirige automaticamente puede hacerlo manualmente");
			out.println("<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table><br><br><table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"login.html\">Login</a></td></tr></table>");
		}
		
		// SI EL USUARIO EXISTE.....
		else if(usuario.getUserName().equals(nombre) && usuario.getUserPass().equals(clave))
		{
			HttpSession httpsesion = req.getSession(false);
			
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
			out.println("Usuario encontrado, usted a entrado en sesion");
			out.println("<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table>");
		}
		
		
		
	}
}
