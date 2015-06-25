package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPruebasGetPost extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Llamada GET Servlet Pruebas");
		
		String nombre = req.getParameter("nombre");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println(nombre+"<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table>");
		
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		System.out.println("Llamada POST Servlet Pruebas");
//		
//		String nombre = req.getParameter("nombre");
//		resp.setContentType("text/html");
//		
//		PrintWriter out = resp.getWriter();
//		out.println(nombre);
//	}
	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException 
	{
		System.out.println("Llamada SERVICE Servlet Pruebas");
		super.service(arg0, arg1);
	}
	
	
}
