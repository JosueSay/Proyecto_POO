// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;
/**
 * Clase Trabajo
 * Tiene como objetivo representar los trabajos que publica el cliente o acepta el 
 * trabajador siendo la clase que realaciona a un cliente con su trabajador
 * @author josue say
 * */

//se importa la libreria Date
import java.util.Date;
//se importa la libreria DateFormat
import java.text.DateFormat;
//se importa la librerira SimpleDateFormat
import java.text.SimpleDateFormat;
//se importa la libreria ArrayList
import java.util.ArrayList;

public class Trabajo {

	// Atributos
	/**
	 * trabajador que acepta el trabajo
	 */
	private Trabajador trabajador;
	/**
	 * descripcion del trabajo
	 */
	private String descripcion;
	/**
	 * fecha de publicacion del trabajo
	 */
	private String fechaPublicacion;
	/**
	 * fecha en que se iniciará el trabajo
	 */
	private String fechaInicio;
	/**
	 * fecha en que se finalizará el trabajo
	 */
	private String fechaFinal;
	/**
	 * precio con el que el cliente publica el trabajo
	 */
	private float precioInicio;
	/**
	 * precio que el trabajador propone
	 */
	private float precioNegocio;
	/**
	 * precio con el que se finaliza y negocia con el trabajador cuando acepta el
	 * trabajo
	 */
	private float precioFinal;
	/**
	 * lista de trabajadores que colocan propuestas para el trabajo
	 */
	private ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();;
	/**
	 * estado en el que se encuentra el trabajo libre: trabajo publicado y nadie lo ha aceptado 
	 * espera: trabajo publicado y existen propuestas de precio del trabajador 
	 * negociando: trabajo publicado y tiene propuestas de trabajadores
	 * pago: el trabajo finalizó pero falta pago del cliente 
	 * finalizado: el trabajo ya finalizó cancelado: el trabajo fue cancelado
	 */
	private String estado;

	// Constructor
	/**
	 * Constructor con 6 parámetros que instancia un trabajo con la fecha actual en
	 * que se publica
	 * 
	 * @param descripcion,  descripcion del trabajo
	 * @param fechaInicio,  fecha en que se iniciará el trabajo
	 * @param fechaFinal,   fecha en que se finalizará el trabajo
	 * @param precioInicio, precio con el que inicia el trabajo (lo coloca el
	 *                      cliente)
	 * @param estado,       estado del trabajo
	 */
	public Trabajo(String descripcion, String fechaInicio, String fechaFinal, float precioInicio, String estado) {
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.precioInicio = precioInicio;
		this.estado = estado;

		// se obtiene la fecha en el momento que se realiza la publicacion
		DateFormat fechaFormato = new SimpleDateFormat("d/M/yyyy");
		// se asigna la fecha de publicacion con el formato indicado
		this.fechaPublicacion = fechaFormato.format(new Date());

	}

	// Getters y Setters
	/**
	 * @return trabajador, variable que almacena el trabajador que acepta el trabajo
	 */
	public Trabajador getTrabajador() {
		return trabajador;
	}

	/**
	 * @param trabajador, variable que modifica el valor del atributo trabajador
	 */
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * @return descripcion, variable que almacena la descripcion del trabajo
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion, variable que modifica el valor del atributo descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return fechaPublicacion, variable que almacena la fecha de publicacion del
	 *         trabajo
	 */
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * @param fechaPublicion, variable que modifica el valor del atributo
	 *                        fechaPublicacion
	 */
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * @return fechaInicio, variable que almacena la fecha en que se inicia el
	 *         trabajo
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio, variable que modifica el valor del atributo fechaInicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return fechaFinal, variable que almacena la fecha en que se finalizará el
	 *         trabajo
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal, variable que modifica el valor del atributo fechaFinal
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * @return precioInicio, variable que almacena el precio con el que se publica
	 *         el trabajo
	 */
	public float getPrecioInicio() {
		return precioInicio;
	}

	/**
	 * @param precioInicio, variable que modifica el valor del atributo precioInicio
	 */
	public void setPrecioInicio(float precioInicio) {
		this.precioInicio = precioInicio;
	}

	/**
	 * @return precioNegocio, variable que almacena el precio que proporciona un
	 *         trabajador como oferta
	 */
	public float getPrecioNegocio() {
		return precioNegocio;
	}

	/**
	 * @param precioNegocio, variable que modifica el valor del atributo
	 *                       precioNegocio
	 */
	public void setPrecioNegocio(float precioNegocio) {
		this.precioNegocio = precioNegocio;
	}

	/**
	 * @return precioFinal, variable que almacena el precio final o negociado del
	 *         trabajo
	 */
	public float getPrecioFinal() {
		return precioFinal;
	}

	/**
	 * @param precioFinal, variable que modifica el valor del atributo precioFinal
	 */
	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	/**
	 * @return estado, variable que almacena el estado del trabajo
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado, variable que modifica el valor del atributo estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return trabajadores, variable que almacena los trabajadores que colocan
	 *         propuestas para el trabajo
	 */
	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	/**
	 * @param trabajadores, variable que modifica el valor del atributo trabajadores
	 */
	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
}
