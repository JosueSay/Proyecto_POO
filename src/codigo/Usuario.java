// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;

/**
 * Clase Usuario, Clase padre de las clases Cliente y Trabajador Tiene como
 * objetivo representar los atributos generales de un Usuario en el programa y
 * metodos que puede realizar el usuario
 * @author josue say
 */

//se importa la libreria ArrayList
import java.util.ArrayList;

public class Usuario {

	// Atributos
	/**
	 * identificador (interno) del usuario
	 */
	protected int id;
	/**
	 * nombre dle usuario
	 */
	protected String nombre;
	/**
	 * apellido del usuario
	 */
	protected String apellido;
	/**
	 * direccion del usuario
	 */
	protected String direccion;
	/**
	 * username del usuario para iniciar sesion en el programa
	 */
	protected String username;
	/**
	 * contraseña del usuario para iniciar sesion en el programa
	 */
	protected String password;
	/**
	 * calificaciones de un usuario tipo estrellas (valores del 1 al 5)
	 */
	protected ArrayList<Integer> calificaciones = new ArrayList<Integer>();

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
	public Usuario(int id, String nombre, String apellido, String direccion, String username, String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.password = password;
		this.username = username;
	}

	// Getters y Setters
	/**
	 * @return id, variable que almacena el identificador interno de un usuario
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id, variable que modifica el valor del atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nombre, variable que almacena el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre, variable que modifica el valor del atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return apellido, variable que almacena el apellido del usuario
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido, variable que modifica el valor del atributo apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return direccion, variable que almacena la direccion del usuario
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion, variable que modifica el valor del atributo direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return password, variable que almacena la contraseña del usuario para
	 *         iniciar sesion
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password, variable que modifica el valor del atributo password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return username, variable que almacena el nombre de usuario para el inicio
	 *         de sesion
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username, variable que modifica el valor del atributo username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return calificaiones, variable que almacena la lista de calificaciones
	 *         proporcionada por otros usuarios
	 */
	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;
	}

	/**
	 * @param calificaciones, variable que modifica el valor del atributo
	 *                        calificaciones
	 */
	public void setCalificaciones(ArrayList<Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
