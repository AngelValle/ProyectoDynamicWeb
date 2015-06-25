package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import clases.Employees;
import interfaces.RECUPERABLE;

public class EmployeesJPADAO implements RECUPERABLE{
	
	private final static Logger logger = LogManager.getRootLogger();
	
	@Override
	public Object leerEmpleado(int id) 
	{
		Employees empleadoleido = new Employees();
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try
		{	
			emf = Persistence.createEntityManagerFactory("UnidadPersonas"); // Archivo XML, Etiqueta: persistence-unit
			em = emf.createEntityManager();
			
			empleadoleido = em.find(Employees.class, id);
		}
		catch(Exception e)
		{
			logger.fatal("ERROR AL LEER EMPLEADO DE LA TABLA EMPLOYEES.");
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		logger.info("EL EMPLEADO HA SIDO LEIDO EXITOSAMENTE.");
		return empleadoleido;
	}
}
