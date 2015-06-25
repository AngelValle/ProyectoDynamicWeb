package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletEmployee extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		
		Connection conexion = null;
		Statement statement = null;
		ResultSet resultset = null;
		Pool pool = null;
		
		String id_employee = req.getParameter("idempleado");
		
		try
		{
			pool = Pool.getInstance();
			conexion = Pool.getConnection();
			statement = conexion.createStatement();
			resultset = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+id_employee);
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			
			if(resultset.next())
			{
				out.println("El usuario buscado por ID: " + id_employee + " es: <br>" + "Nombre: " + resultset.getString(2).toString() + " , " + "Salario: " + resultset.getBigDecimal(8).toString()+" €"+"<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\"><tr><td><a href=\"index.html\">Inicio</a></td></tr></table>");
			}
			else 
			{
				out.println("No se ha encontrado ningun empleado con la ID indicada.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			Pool.liberarRecursos(conexion, statement, resultset);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
