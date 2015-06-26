package servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Filter implements javax.servlet.Filter {

	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void destroy() 
	{
		log.trace("Se ha destruido el Filter");
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException 
	{
		long tiempoinicio = System.currentTimeMillis();
		log.trace("Pasada por doFilter");
		filterchain.doFilter(servletrequest, servletresponse);
		long tiempofin = System.currentTimeMillis();
		log.trace("Tiempo de filtro: " + (tiempofin-tiempoinicio));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		log.trace("Se ha iniciado el Filter");
	}

}
