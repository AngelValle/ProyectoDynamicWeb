package dao;

import org.hibernate.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import clases.Employees;
import conexiones.SessionManager;
import interfaces.RECUPERABLE;
import sentenciasSQL.SentenciasSQL;

public class EmployeesHibernateDAO implements RECUPERABLE{
	
	private final static Logger logger = LogManager.getRootLogger();
	private SuperDAO superdao = new SuperDAO();
	
	@Override
	public Object leerEmpleado(int id) 
	{
		Employees empleadoleido = new Employees();
		Session s_sesion = null;

		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			empleadoleido = (Employees)superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeesselectoid(id)).addEntity(Employees.class).uniqueResult();
		}
		catch(Exception e)
		{
			logger.fatal("ERROR AL LEER EMPLEADO DE LA TABLA EMPLOYEES.");
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
//			SessionManager.cerrarFactory();
		}
		logger.info("EL EMPLEADO HA SIDO LEIDO EXITOSAMENTE.");
		return empleadoleido;
	}
}
