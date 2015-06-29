package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FiltroSesionActiva implements Filter {

	private static final Logger logger = LogManager.getRootLogger();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException 
	{
		HttpServletRequest httpservletrequest = (HttpServletRequest)servletrequest;
		HttpServletResponse httpservletresponse = (HttpServletResponse)servletresponse;
		
		if(null==httpservletrequest.getSession(false))
		{
			if(httpservletrequest.getRequestURI().equals("/ProyectoWebAngel/ServletAutentificacion") || httpservletrequest.getRequestURI().equals("/ProyectoWebAngel/login.html") || httpservletrequest.getRequestURI().equals("/ProyectoWebAngel/index.html"))
			{
				filterchain.doFilter(httpservletrequest, httpservletresponse);
			}
			else if(!httpservletrequest.getRequestURI().equals("/ProyectoWebAngel/ServletAutentificacion") && !httpservletrequest.getRequestURI().equals("/ProyectoWebAngel/login.html") && !httpservletrequest.getRequestURI().equals("/ProyectoWebAngel/index.html"))
			{
				httpservletresponse.sendRedirect("/ProyectoWebAngel/login.html");
			}
		}
		else if (null!=httpservletrequest.getSession(false)) 
		{
			filterchain.doFilter(httpservletrequest, httpservletresponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
