package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Employees;
import dao.EmployeesHibernateDAO;
import dao.EmployeesJDBCDAO;
import dao.EmployeesJPADAO;
import servicios.EmployeesServices;


public class ServletLeerEmployee_JDBC_HIBERNATE_JPA extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Integer id_employee = Integer.parseInt(req.getParameter("idempleado"));
		
		EmployeesHibernateDAO empleadoaleer = new EmployeesHibernateDAO(); // Bajo que forma queremos leer un Employees
//		EmployeesJDBCDAO empleadoaleer = new EmployeesJDBCDAO(); // Bajo que forma queremos leer un Employees // AUN NO FUNCIONAL
//		EmployeesJPADAO empleadoaleer = new EmployeesJPADAO(); // Bajo que forma queremos leer un Employees // AUN NO FUNCIONAL

		EmployeesServices es = new EmployeesServices();
		es.setO_dao(empleadoaleer);
		
		Employees empleadoleido = (Employees)es.leerEmpleadoService(id_employee);

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<table><tr><th>Lista:</th></tr><tr><td><ul><li>"+empleadoleido.toString()+"</li></ul></td></tr></table>"+"<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
