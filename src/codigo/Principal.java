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
		

		// listas de trabajos
		ArrayList<Trabajo> publicados = new ArrayList<Trabajo>();
		ArrayList<Trabajo> proceso = new ArrayList<Trabajo>();
		ArrayList<Trabajo> pagar = new ArrayList<Trabajo>();
		//ArrayList<Trabajo> completo = new ArrayList<Trabajo>();
		ArrayList<Trabajo> todos = new ArrayList<Trabajo>();

		Trabajo t1 = new Trabajo(1, "Se busca plomero", "25/11/2022", "27/11/2022", 45);
		Trabajo t2 = new Trabajo(2, "Se busca electricista", "25/11/2022", "27/11/2022", 100);
		Trabajo t3 = new Trabajo(3, "Se busca estuadiante", "25/11/2022", "27/11/2022", 75);
		Trabajo t4 = new Trabajo(4, "Se busca mago", "25/11/2022", "27/11/2022", 79);
		Trabajo t5 = new Trabajo(5, "Se busca programador", "25/11/2022", "27/11/2022", 120);
		Trabajo t6 = new Trabajo(6, "Se busca cerrajero", "25/11/2022", "27/11/2022", 80);

		Usuario tr1 = new Trabajador(1, "Jorge", "Lopez", "3sdsd78", "Electricista", "Jor1", "12345");
		Usuario tr2 = new Trabajador(2, "Alex", "chen", "d5sds6", "plomero", "Al1", "aa1");
		Usuario tr3 = new Trabajador(3, "Pablo", "cruz", "5ds6", "carpintero", "Pa1", "aa2");
		Usuario tr4 = new Trabajador(4, "Pedro", "figueroa", "8d7sd", "cerrajero", "Pe1", "aa3");
		Usuario tr5 = new Trabajador(5, "jose", "hernandez", "8ds79", "estudiante", "Js1", "aa4");
		Usuario tr6 = new Trabajador(6, "gabriel", "castillo", "s8d7s9", "Electricista", "gab1", "aa5");

		publicados.add(t1);
		publicados.add(t2);

		t3.setTrabajador((Trabajador) (tr1));
		t3.setEstado("espera");
		t3.setPrecioNegocio(80);
		proceso.add(t3);

		t4.setTrabajador((Trabajador) (tr4));
		t4.setEstado("espera");
		t4.setPrecioNegocio(40);
		proceso.add(t4);

		t5.setTrabajador((Trabajador) (tr5));
		t5.setEstado("realizando");
		t5.setPrecioNegocio(10);
		proceso.add(t5);

		t6.setTrabajador((Trabajador) (tr5));
		t6.setEstado("pago");
		t6.setPrecioNegocio(10);
		pagar.add(t5);

		todos.add(t1);
		todos.add(t2);
		todos.add(t3);
		todos.add(t4);
		todos.add(t5);
		todos.add(t6);

		
		
		Usuario u1 = new Cliente(1, "josue", "say", "03-ap-p", "jos1", "admin");
		Cliente cliente = (Cliente)(u1);
		cliente.setTrabajosPublicados(publicados);
		cliente.setTrabajosPagar(pagar);
		cliente.setTodosTrabajos(todos);
		cliente.setTrabajosEnCola(proceso);
		
		pruebaU.add(cliente);
		op.setUsuarios(pruebaU);
		
		
		
		// mostrar menu inicial del programa
		op.menuInicial();

	}

}
