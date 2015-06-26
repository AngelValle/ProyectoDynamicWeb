package servicios;

import java.util.List;

import org.hibernate.Session;

import sentenciasSQL.SentenciasSQL;

import conexiones.SessionManager;
import dao.SuperDAO;
import clases.Departments;
import clases.Employees;

public class DepartmentsServices {
	
	@SuppressWarnings("unchecked")
	public List<Departments> listaDepartamentosConTrabajadores()
	{
		List<Departments> list_departamentos = null;
		
		Session s_sesion = SessionManager.obtenerSesionNueva();
		list_departamentos = s_sesion.createSQLQuery(SentenciasSQL.recogerlistadepartments2).addEntity(Departments.class).list();
		
		return list_departamentos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employees> listaEmpleadoPorDepartamento(int id_departamento)
	{
		List<Employees> list_employees = null;
		
		Session s_sesion = SessionManager.obtenerSesionNueva();
		list_employees = s_sesion.createSQLQuery(SentenciasSQL.recogeremployeespordepartamento(id_departamento)).addEntity(Employees.class).list();

		return list_employees;
	}
	
	
	
	
	
}
