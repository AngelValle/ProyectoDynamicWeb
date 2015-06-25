package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletConexionesActivas extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		@SuppressWarnings("unchecked")
		Map<String, HttpSession> map_sesiones = (Map<String, HttpSession>)req.getServletContext().getAttribute("map_sesiones");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		Iterator it_sesiones = map_sesiones.entrySet().iterator();
		int contador = 0;
		
		while(it_sesiones.hasNext())
		{
			contador++;
			@SuppressWarnings("unchecked")
			Map.Entry<String, HttpSession> entrada = (Map.Entry<String, HttpSession>)it_sesiones.next();
			out.println("Sesion "+contador+" "+req.getSession().getAttribute("nombre")+" : "+entrada.getKey()+"<br>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		super.doPost(req, resp);
	}

}
