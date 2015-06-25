package servicios;

import interfaces.RECUPERABLE;

public class EmployeesServices {

	private RECUPERABLE o_dao;

	public Object leerEmpleadoService(int id)
	{
		return o_dao.leerEmpleado(id);
	}
	
	public RECUPERABLE getO_dao() 
	{
		return o_dao;
	}

	public void setO_dao(RECUPERABLE o_dao) 
	{
		this.o_dao = o_dao;
	}
}
