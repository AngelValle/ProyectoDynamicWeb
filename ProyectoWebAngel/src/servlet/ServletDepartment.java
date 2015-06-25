package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import conexiones.SessionManager;

import sentenciasSQL.SentenciasSQL;
import clases.Employees;
import dao.SuperDAO;

public class ServletDepartment extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Integer id_departamento = Integer.parseInt(req.getParameter("departmentname"));
		List list_employees = null;
		
		SuperDAO superdao = new SuperDAO();	
		Session s_sesion = SessionManager.obtenerSesionNueva();
		superdao.setSesion(s_sesion);
		
		list_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeespordepartamento(id_departamento)).addEntity(Employees.class).list();
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<table><tr><th>Lista:</th></tr><tr><td><ul>");
		for (Object emp : list_employees) 
		{
			Employees empleado = (Employees)emp;
			out.println("<li>"+empleado.toString()+"</li>");
		}
		out.println("</ul></td></tr></table>"+"<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
