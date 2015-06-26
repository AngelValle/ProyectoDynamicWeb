package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DepartmentsServices;
import clases.Departments;

public class ServletDepartment2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String refresco = req.getParameter("refresco");
		
		if(refresco.equals("Refrescar"))
		{
			List<Departments> list_departamentos = null;
			DepartmentsServices departmentsservices = new DepartmentsServices();
			
			list_departamentos = departmentsservices.listaDepartamentosConTrabajadores();
			Iterator<Departments> it_departamentos = list_departamentos.iterator();
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			
			out.println("<h1 align=\"center\"> department.html</h1>"+
						"<table align=\"center\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\">"+
							"<tr><th align=\"center\" bgcolor=\"#BBBBBB\" height=\"25\" width=\"800\">Ingresar ID de Departamento</th></tr>"+
						"</table>"+
						"<br>"+
						"<table align=\"center\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\" frame=\"above\" width=\"800\">"+
							"<tr>"+
								"<td>"+
									"<form action=\"ServletDepartment\" method=\"get\">"+
										"<p>ID Departamento: <select name=\"departmentname\">");
			
			while(it_departamentos.hasNext())
			{
				Departments departamento = (Departments)it_departamentos.next();
				out.println("<option value=\""+departamento.getDepartmentId()+"\">"+departamento.getDepartmentName()+"</option>");
			}
			out.println("</select><input type=\"submit\" value=\"Enviar\"></p>"+
									"</form>"+
								"</td>"+
							"</tr>"+
						"</table>"+
						
						"<table align=\"right\" bordercolor=\"BLACK\" bgcolor=\"#FFFFFF\">"+
							"<tr><td><a href=\"index.html\">Inicio</a></td></tr>"+
						"</table><br><br><br>");
			
		}
		req.getRequestDispatcher("/ServletConexionesActivas").include(req, resp);
	}		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
