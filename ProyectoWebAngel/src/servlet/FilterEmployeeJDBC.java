package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilterEmployeeJDBC implements Filter {
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void destroy() 
	{
		log.trace("Se ha destruido el Filter(EmployeeJDBC)");
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException 
	{
		
		long tiempoinicio = System.currentTimeMillis();
		log.trace("Pasada por doFilter(EmployeeJDBC)");
		filterchain.doFilter(servletrequest, servletresponse);
		long tiempofin = System.currentTimeMillis();
		log.trace("Tiempo de filtro(EmployeeJDBC): " + (tiempofin-tiempoinicio));
		log.trace("Contador de peticiones: "+servletrequest.getServletContext().getAttribute("peticiones_contador"));
		log.trace("Peticiones Activas: "+servletrequest.getServletContext().getAttribute("peticiones_activas"));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		log.trace("Se ha iniciado el Filter(EmployeeJDBC)");
	}

}
