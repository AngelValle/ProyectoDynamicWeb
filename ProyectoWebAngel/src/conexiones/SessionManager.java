package conexiones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Clase que controla las session y las sessionfactory
 * @author Angel Valle
 *
 */
public class SessionManager {
	
	private static Configuration c_configuracion = new Configuration().configure();
	private static StandardServiceRegistryBuilder b_builder = new StandardServiceRegistryBuilder().applySettings(c_configuracion.getProperties());
	private static SessionFactory s_factory = c_configuracion.buildSessionFactory(b_builder.build()); // PATRON "SINGLETON" : CREAMOS UN UNICO SessionFactory.
	
	private SessionManager (){} // PATRON "SINGLETON" : CONSTRUCTOR PRIVADO.
	
	/**
	 * Metodo que nos devuelve la SessionFactory ya creada. (Unica instancia, patron singleton).
	 * @return
	 * SessionFactory (Singleton en SessionManager)
	 */
	public static SessionFactory getSessionFactory ()
	{
		return s_factory;
	}
	
	/**
	 * Metodo que nos devuelve una nueva session creada apartir de la SessionFactory de SessionManager (Patron Singleton)
	 * @return
	 * session (Nueva session de la unica SessionFactory de SessionManager)
	 */
	public static Session obtenerSesionNueva ()
	{
		return s_factory.openSession();
	}
	
	/**
	 * Metodo que nos cierra la session abierta anteriormente con obtenerSesionNueva()
	 * @param sesion
	 * Necesita de un objeto session que cerrar.
	 */
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
	}
	
	/**
	 * Metodo que nos cierra la unica SessionFactory de la instancia SessionManager.
	 */
	public static void cerrarFactory()
	{
		s_factory.close();
	}
}
