package sentenciasSQL;

import clases.Employees;

public class SentenciasSQL {
	
	/**
	 * String utilizada para recoger una lista de los diferentes DEPARTMENT_ID de la tabla DEPARTMENTS. 
	 */
	public static String recogerlistadepartments2 = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID IS NOT NULL)";
	/**
	 * String utilizada para recoger todos los empleados de la tabla EMPLOYEES.
	 */
	public static String recogeremployees = "SELECT * FROM EMPLOYEES ";
	/**
	 * String utilizada para incrementar el salario (Valor a incrementar el salario).
	 */
	public static String incrementosalarioemployees = "1.2";
	/**
	 * String utilizada para recoger una lista de los diferentes DEPARTMENT_ID de la tabla EMPLOYEES. 
	 */
	public static String recogerlistadepartments = "SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES WHERE department_id IS NOT NULL";
	/**
	 * String utilizada para recoger una lista del mayore asalariado de cada departamento.
	 */
	public static String recogerempleadomasasalariadodecadadepartamento = "SELECT * FROM EMPLOYEES WHERE (DEPARTMENT_ID, SALARY) IN (SELECT DEPARTMENT_ID, MAX(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID) ORDER BY DEPARTMENT_ID DESC";
	/**
	 * Metodo que nos devuelve una String utilizada para leer un empleado por su EMPLOYEE_ID
	 * @param ObjectDTO
	 * Empleado que recogemos, del que extraemos su ID (ObjectDTo.getEmployeeId()) para hacer una busqueda con ese ID.
	 * @return
	 * String construida.
	 */
	public static String recogeremployeesselecto(Employees ObjectDTO)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ObjectDTO.getEmployeeId();
		return recogeremployeesselecto;
	}
	
	/**
	 * Metodo que nos devuelve una String utilizada para leer los empleados de un departamento concreto.
	 * @param departamento
	 * Recogemos un INT que usaremos como DEPARTMENT_ID para ejecutar la query.
	 * @return
	 * String construida.
	 */
	public static String recogeremployeespordepartamento(int departamento)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+departamento+" ORDER BY SALARY DESC";
		return recogeremployeesselecto;
	}
	
	/**
	 * Metodo que nos devuelve una String utilizada para leer un empleado por su EMPLOYEE_ID
	 * @param ID
	 * Recogemos un INT(ID) que usaremos para hacer una busqueda con ese ID.
	 * @return
	 * String construida.
	 */
	public static String recogeremployeesselectoid(int ID)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ID;
		return recogeremployeesselecto;
	}
	
	/**
	 * Metodo que nos devuelve una String utilizada para insertar un empleado en EMPLOYEES.
	 * @param ObjectDTO
	 * Recogemos un EMPLOYEES que posteriormente insertaremos en la tabla EMPLOYEES.
	 * @return
	 * String construida.
	 */
	public static String insertaremployees(Employees ObjectDTO)
	{
		String insertaremployees = "INSERT INTO EMPLOYEES VALUES "+"'"+ObjectDTO.getFirstName()+"'"+","+"'"+ObjectDTO.getLastName()+"'"+","+"'"+ObjectDTO.getEmail()+"'"+","+"'"+ObjectDTO.getPhoneNumber()+"'"+","+"'"+ObjectDTO.getHireDate()+"'"+","+"'"+ObjectDTO.getSalary()+"'";
		return insertaremployees;
	}
	
	/**
	 * Metodo que nos devuelve una String utilizada para borrar un empleado de EMPLOYEES.
	 * @param ObjectDTO
	 * Recogemos un EMPLOYEES que posteriormente borraremos de la tabla EMPLOYEES.
	 * @return
	 * String construida.
	 */
	public static String borraremployees(Employees ObjectDTO)
	{
		String borraremployees = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ObjectDTO.getEmployeeId();
		return borraremployees;
	}
}
