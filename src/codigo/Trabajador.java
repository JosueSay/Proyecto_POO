// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;

/**
 * Clase Trabajador Clase hija de la clase Usuario Tiene como objetivo
 * representar los atributos y métodos específicos de un usuario de tipo
 * Trabajador
 * 
 * @author josue say
 */

//se importa la libreria ArrayList
//import java.util.ArrayList;

public class Trabajador extends Usuario {

	// Constructor
	/**
	 * Constructor con 6 parámetros
	 * 
	 * @param id,         identificador interno del usuario
	 * @param nombre,     nombre del usuario
	 * @param apellido,   apellido del usuario
	 * @param direccione, direccion del usuario
	 * @param username,   nombre de usuario para el inicio de sesion
	 * @param password,   contraseña del usuario para el inicio de sesion
	 */
	public Trabajador(int id, String nombre, String apellido, String direccion, String username, String password) {
		super(id, nombre, apellido, direccion, username, password);

	}

	// un usuario debe tener trabajos colocar limites 1 solo trabajo o más
	// debe de ver los trabajos publicados por clientes
	// debe de poder proporcionar una oferta en el precioNegocio de Trabajo
	// (opcional )debe de poder calificar cliente
	
	
}
