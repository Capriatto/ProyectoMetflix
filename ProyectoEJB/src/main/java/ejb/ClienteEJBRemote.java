package ejb;

import java.sql.Date;

import javax.ejb.Remote;

import co.edu.uniquindio.com.Cliente;
import co.edu.uniquindio.com.Empleado;
import excepciones.InformacionRepetidaException;

/**
 * Interfaz que determina los metodos de acceso del EJB de Cliente.
 **/
@Remote
public interface ClienteEJBRemote {
	
	/**
	 * Permite hacer el cambio de contraseña a los clientes
	 * @param usuario
	 * @param contraseñaNueva
	 * @throws InformacionRepetidaException
	 */

	public boolean cambioContrasena(String usuario, String contraseñaNueva) throws InformacionRepetidaException;
	
	/**
	 * Permite registrar una consulta tecnica en una base de datos
	 * @param id
	 * @param consulta
	 * @param estado
	 * @param f_consulta_tecnica
	 * @param cliente
	 * @param empleado
	 * @return
	 */
	public boolean registroConsultaTecnica(String id, String consulta, int estado, Date f_consulta_tecnica, Cliente cliente,
		    Empleado empleado);
	
	
}


