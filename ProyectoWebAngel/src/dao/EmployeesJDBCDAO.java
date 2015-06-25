package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import clases.Employees;
import interfaces.RECUPERABLE;
import sentenciasSQL.SentenciasSQL;

public class EmployeesJDBCDAO implements RECUPERABLE{

	private final static Logger logger = LogManager.getRootLogger();
	
	@Override
	public Object leerEmpleado(int id) 
	{
		Employees empleadoleido = null;
		Connection conexion = null;
		ResultSet resultset = null;
		Statement statement = null;

		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","HR","PASSWORD");
			statement = conexion.createStatement();
			resultset = statement.executeQuery(SentenciasSQL.recogeremployeesselectoid(id));
			empleadoleido = resultset2dtoemployees(resultset);
		
		}
		catch(Exception e)
		{
			logger.fatal("ERROR AL LEER EMPLEADO DE LA TABLA EMPLOYEES.");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				resultset.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try 
			{
				statement.close();
			} 
			catch (SQLException e) 
			{
				logger.fatal("ERROR AL CERRAR STATEMENT.");
				e.printStackTrace();
			}
			try 
			{
				conexion.close();
			} 
			catch (SQLException e) 
			{
				logger.fatal("ERROR AL CERRAR CONNECTION.");
				e.printStackTrace();
			}
		}
		logger.info("EL EMPLEADO HA SIDO LEIDO EXITOSAMENTE.");
		return empleadoleido;
	}
	
	public static Employees resultset2dtoemployees (ResultSet rset) throws Exception
	{
		Employees employees = null;
		if(rset.next())
		{
//			employees = new Employees(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getBigDecimal(8));
		}
		return employees;
	}
}
