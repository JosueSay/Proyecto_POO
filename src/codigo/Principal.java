// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;

/**
 * Clase Principal
 * Es la clase main que tiene como objetivo realizar en consola las acciones del controlador Operaciones
 * @author josue say
 * */

//se importa la libreria ArrayList para mostrar ejemplos
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		// instancia del controlador
		Operaciones op = new Operaciones();

		/**
		 * Ejemplo
		 */
		ArrayList<Usuario> pruebaU = new ArrayList<Usuario>();
		Usuario u1 = new Cliente(1, "josue", "say", "03-ap-p", "jos1", "admin");
		pruebaU.add(u1);
		op.setUsuarios(pruebaU);

		// mostrar menu inicial del programa
		op.menuInicial();

	}

}
