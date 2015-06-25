package dao;

import org.hibernate.Session;

/**
 * Clase utilizada para compartir una SESSION entre las clases SERVICES y la clases DAO
 * @author Angel Valle
 *
 */
public class SuperDAO {
	
	/**
	 * Atributo session utilizado para compartir la session desde diferentes clases.
	 */
	private Session sesion = null;

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session session) {
		sesion = session;
	}
}
