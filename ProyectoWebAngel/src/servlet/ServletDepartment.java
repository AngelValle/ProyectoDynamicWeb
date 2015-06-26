package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servicios.DepartmentsServices;
import clases.Employees;

public class ServletDepartment extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Integer id_departamento = Integer.parseInt(req.getParameter("departmentname"));
		List<Employees> list_employees = null;
		
		DepartmentsServices departmentsservices = new DepartmentsServices();
		
		list_employees = departmentsservices.listaEmpleadoPorDepartamento(id_departamento);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<table><tr><th>Lista:</th></tr><tr><td><ul>");
		for (Employees emp : list_employees) 
		{
			out.println("<li>"+emp.toString()+"</li>");
		}
		out.println("</ul></td></tr></table>"+"<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table>");
		
		
		
		@SuppressWarnings("unchecked")
		Map<String, HttpSession> map_sesiones = (Map<String, HttpSession>)req.getServletContext().getAttribute("map_sesiones");
		Iterator it_sesiones = map_sesiones.entrySet().iterator();
		
		int contador = 0;
		while(it_sesiones.hasNext())
		{
			contador++;
			@SuppressWarnings("unchecked")
			Map.Entry<String, HttpSession> entrada = (Map.Entry<String, HttpSession>)it_sesiones.next();
			out.println("<p>Sesion "+contador+" "+req.getSession().getAttribute("nombre")+" : "+entrada.getKey()+"<br>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
