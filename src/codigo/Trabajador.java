// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;

import java.util.ArrayList;

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

	// Atributos
	/**
	 * trabajo que almacena el trabajo que realiza el trabajador
	 */
	private Trabajo trabajo;

	/**
	 * variable que identifica si el trabajador puede obtener un trabajo, solo optar
	 * por un trabajo a la vez true: puede pedir y tomar un trabajo, false: no puede
	 * pedir ni tomar un trabajo
	 */
	private boolean optarTrabajo = true;
	/**
	 * profesion del trabajador
	 */
	private String profesion;

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
	public Trabajador(int id, String nombre, String apellido, String direccion, String profesion, String username,
			String password) {
		super(id, nombre, apellido, direccion, username, password);
		this.profesion = profesion;
	}

	// Getters y Setters
	/**
	 * @return trabajo, variable que almacena el trabajo que está realizando el
	 *         trabajador
	 */
	public Trabajo getTrabajo() {
		return trabajo;
	}

	/**
	 * @param trabajo, variable que modifica el atributo trabajo
	 */
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	/**
	 * @return optarTrabajo, variable que identifica si un trabajador puede pedir y
	 *         tomar un trabajo
	 */
	public boolean isOptarTrabajo() {
		return optarTrabajo;
	}

	/**
	 * @param optarTrabajo, variable que modifica el atributo optarTrabajo
	 */
	public void setOptarTrabajo(boolean optarTrabajo) {
		this.optarTrabajo = optarTrabajo;
	}

	/**
	 * @return profesion, variable que almacena la profesion del trabajador
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion, variable que modifica el atributo profesion
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}



}
