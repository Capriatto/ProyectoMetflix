package Principal;

import java.sql.Date;
import java.text.ParseException;

import Delegados.AdministradorDelegado;
import co.edu.uniquindio.com.Empleado;
import co.edu.uniquindio.com.Pelicula;
import excepciones.ElementoRegistradorException;
import excepciones.InformacionRepetidaException;
import excepciones.PersonaNoEncontradaException;

/**
 * Clase que permite controlar los metodos de la capa de negocio
 * 
 * @author German
 *
 */
public class Principal {
	private static final Principal instancia = new Principal();
	private AdministradorDelegado administradorDelegado = new AdministradorDelegado().getInstancia();

	public static Principal getInstancia() {
		return instancia;
	}

	/////////////////////// CRUD EMPLEADO////////////////

	/**
	 * Metodo para registar empleado
	 * 
	 * @param cedula
	 * @param apellido
	 * @param contrasena
	 * @param correo
	 * @param estado
	 * @param nombre
	 * @param usuario
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public boolean registroEmpleado(String cedula, String apellido, String contrasena, String correo, int estado,
			String nombre, String usuario) throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.registroEmpleado(cedula, apellido, contrasena, correo, estado, nombre, usuario);
	}

	/**
	 * Metodo para buscar empleado
	 * 
	 * @param cedula
	 * @return
	 * @throws ElementoRegistradorException
	 * @throws InformacionRepetidaException
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.buscarEmpleadoPorNombreUsuario(cedula);
	}

	/**
	 * Metodo para eliminar un empleado
	 */
	public boolean eliminarEmpleado(String cedula, int estado)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.eliminarEmpleado(cedula, estado);
	}

	/**
	 * Metodo para modificar un empleado
	 */
	public boolean modificarEmpleado(String cedula, String puesto, double salario)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.modificarEmpleado(cedula, puesto, salario);
	}

	/**
	 * Metodo para recuperar contraseña empleado
	 * 
	 * @param cedula
	 * @return
	 * @throws PersonaNoEncontradaException
	 * @throws InformacionRepetidaException
	 * @throws ElementoRegistradorException
	 */
	public String recuperarContrasenia(String cedula)
			throws ElementoRegistradorException, InformacionRepetidaException {
		return administradorDelegado.recuperarContrasenia(cedula);
	}

	///////////////////// CRUD PELICULA////////////////////////////
	/**
	 * Metodo delegado para registrar pelicula
	 */
	public boolean registroPelicula(Date  añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ElementoRegistradorException, InformacionRepetidaException, ParseException {
		return administradorDelegado.registroPelicula( añoLanzamiento, descripcion, estado, nombre, precio);
	}

	/**
	 * Metodo delegado para buscar pelicula
	 */
	public Pelicula buscarPeliculaPorNombre(String nombre) {
		return administradorDelegado.buscarPeliculaPorNombre(nombre);
	}

	/**
	 * Metodo delegado para modificar pelicula
	 */
	public boolean modificarPelicula(String añoLanzamiento, String descripcion, int estado, String nombre,
			double precio) throws ParseException {
		return administradorDelegado.modificarPelicula(añoLanzamiento, descripcion, estado, nombre, precio);
	}

	/**
	 * Metodo delegado para eliminar pelicula
	 */
	public boolean eliminarPelicula(String nombre, int estado) {
		return administradorDelegado.eliminarPelicula(nombre, estado);
	}

	/////////////////////////////////////////////////////////////////////////////////
	public Principal() {
	}

	public static void main(String[] args) {
	}

}
