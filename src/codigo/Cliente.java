// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;
/**
 * Clase Cliente
 * Clase hija de la clase Usuario
 * Tiene como objetivo representar los atributos y métodos específicos de un usuario de tipo Cliente
 * @author josue say
 * */

//se importa la libreria ArrayList
import java.util.ArrayList;

public class Cliente extends Usuario {

	// Atributos
	/**
	 * trabajos que el Cliente a publicado
	 */
	private ArrayList<Trabajo> trabajosPublicados = new ArrayList<Trabajo>();
	/**
	 * trabajos que el cliente publicó y se están realizando
	 */
	private ArrayList<Trabajo> trabajosEnCola = new ArrayList<Trabajo>();
	/**
	 * trabajos que el trabajador ha completado y no se han pagado
	 */
	private ArrayList<Trabajo> trabajosPagar = new ArrayList<Trabajo>();
	/**
	 * trabajos que el trabajador ha completados y pagados o cancelados
	 */
	private ArrayList<Trabajo> trabajosFinalizados = new ArrayList<Trabajo>();
	/**
	 * todos los trabajos de cliente
	 */
	private ArrayList<Trabajo> todosTrabajos = new ArrayList<Trabajo>();

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
	public Cliente(int id, String nombre, String apellido, String direccion, String username, String password) {
		super(id, nombre, apellido, direccion, username, password);

	}

	// Getters y Setters
	/**
	 * @return trabajosPublicados, variable que almacena una lista de todos los
	 *         trabajos publicados por el cliente
	 */
	public ArrayList<Trabajo> getTrabajosPublicados() {
		return trabajosPublicados;
	}

	/**
	 * @param trabajosPublicados, variable que modifica el valor del atributo de los
	 *                            trabajos publicados por el Cliente
	 */
	public void setTrabajosPublicados(ArrayList<Trabajo> trabajosPublicados) {
		this.trabajosPublicados = trabajosPublicados;
	}

	/**
	 * @return trabajosEnCola, variable que almacena una lista de todos los trabajos
	 *         publicados por el cliente y que han sido aceptados
	 */
	public ArrayList<Trabajo> getTrabajosEnCola() {
		return trabajosEnCola;
	}

	/**
	 * @param trabajosEnCola, variable que modifica el valor del atributo de los
	 *                        trabajos que han sido aceptados por el Cliente
	 */
	public void setTrabajosEnCola(ArrayList<Trabajo> trabajosEnCola) {
		this.trabajosEnCola = trabajosEnCola;
	}

	/**
	 * @return trabajosFinalizados, variable que almacena una lista de todos los
	 *         trabajos que han sido completados/finalizados o cancelados por el
	 *         cliente
	 */
	public ArrayList<Trabajo> getTrabajosFinalizados() {
		return trabajosFinalizados;
	}

	/**
	 * @param trabajosFinalizados, variable que modifica el valor del atributo de
	 *                             los trabajos cancelados o finalizados
	 */
	public void setTrabajosFinalizados(ArrayList<Trabajo> trabajosFinalizados) {
		this.trabajosFinalizados = trabajosFinalizados;
	}

	/**
	 * @return todosTrabajos, variable que almacena una lista de todos los trabajos
	 *         del Cliente
	 */
	public ArrayList<Trabajo> getTodosTrabajos() {
		return todosTrabajos;
	}

	/**
	 * @param todosTrabajos, variable que modifica el valor del atributo
	 *                       todosTrabajos
	 */
	public void setTodosTrabajos(ArrayList<Trabajo> todosTrabajos) {
		this.todosTrabajos = todosTrabajos;
	}

	/**
	 * @return trabajosPagar, variable que almacena una lista de todos los trabajos
	 *         que estan pendientes por pagar
	 */
	public ArrayList<Trabajo> getTrabajosPagar() {
		return trabajosPagar;
	}

	/**
	 * @param trabajosPagar, variable que modifica el valor del atributo
	 *                       trabajosPagar
	 */
	public void setTrabajosPagar(ArrayList<Trabajo> trabajosPagar) {
		this.trabajosPagar = trabajosPagar;
	}
}
