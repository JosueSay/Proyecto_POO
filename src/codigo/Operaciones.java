// la siguiente linea de codigo contiene las clases del programa, si hay error, descomentar la linea de codigo
package codigo;

/**
 * Clase Opearaciones
 * Es el controlador del programa, tiene como objetivo realizar la interacción de la clase Principal (main) con las demás clases, 
 * tambien tiene la funcion de mostrar y realizar todas las acciones que puede realizar el usuario
 * @author josue say
 * */

/**
 * se importa InputMismatchException para el manejo de datos inadecuados para la clase Scanner
 * */
import java.util.InputMismatchException;
/**
 * se importa la libreria Scanner para permitir el ingreso de datos
 * */
import java.util.Scanner;
/**
 * se importa la libreria ArrayList para el manejo de listas
 * */
import java.util.ArrayList;

public class Operaciones {

	// Atributos
	/**
	 * lista de usuarios
	 */
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	// Constructor
	/**
	 * constructor sin paramatros utilizado para instanciar la clase operaciones
	 */
	public Operaciones() {

	}

	// Variable Global
	// instancia de scanner para el ingreso de datos
	Scanner r = new Scanner(System.in);

	/**
	 * metodo para mostrar el menu de iniciar/registrar al usuario
	 */
	public void menuInicial() {

		// variable para el ingreso de la opcion del usuario
		int respuesta;
		// variable que permite seguir mostrando el menu
		// true: mostrar el menu nuevamente
		// false: no mostrar el menu nuevamente
		boolean continuar;

		System.out.println("================================");
		System.out.println("     	||Bienvenido||     		");
		System.out.println("================================");
		System.out.println("");

		// ciclo para mostrar menu
		do {

			// evaluar errores
			try {

				System.out.println("Ingresa la opcion que desees:");
				System.out.println("\n1. Iniciar Sesion\n2. Registrarse\n3. Salir");
				System.out.print("\nRespuesta: ");
				respuesta = r.nextInt();

				// iniciar sesion
				if (respuesta == 1) {

					// mostrar el menu segun si se encuentra el usuario
					continuar = iniciarSesionUsuario();

					// registrarse
				} else if (respuesta == 2) {

					// registrar al usuario y no mostrar el menu nuevamente
					registrarUsuario();
					continuar = false;

					// salir del programa
				} else if (respuesta == 3) {

					System.out.println("");
					System.out.println("======================================");
					System.out.println("       ||Saliste del programa||       ");
					System.out.println("======================================");

					// no mostrar el menu nuevamente
					continuar = false;

					// la respuesta ingresada es un entero que no esta en las opciones
				} else {

					System.out.println("La respuesta " + "\"" + respuesta + "\""
							+ " no esta dentro de las opciones permitidas. Intenta nuevamente");
					System.out.println("");
					continuar = true;

				}

				// la respuesta ingresada no es un entero
			} catch (InputMismatchException e) {

				System.out.println(
						"La opcion ingresada no es valida, debe ingresar un numero entero. Intenta nuevamente");
				System.out.println("");
				r.next();
				continuar = true;
			}

			// si hubo un inadecuado ingreso de datos, mostrar el menu nuevamente
		} while (continuar);

	}

	/**
	 * metodo para iniciar sesion segun el ingreso de datos
	 * 
	 * @return continuarI, variable que permite identificar si hay que mostrar el
	 *         menu inicial nuevamente true: repetir el menu false: no repetir el
	 *         menu
	 */
	public boolean iniciarSesionUsuario() {

		// variable que permite identificar si hay mal ingreso de datos
		// true: hay mal ingreso de datos, false: no hay mal ingreso de datos
		boolean continuarI;
		// username
		String usern;
		// pasword
		String pass;
		// tipo de usuario
		int tipoU;

		System.out.print("\nIngresa tu usename: ");
		usern = r.next();
		System.out.print("Ingresa tu password: ");
		pass = r.nextLine();
		pass = r.nextLine();

		tipoU = validarTipoUsuario();

		// validar que el usuario exista para que pueda iniciar sesion
		Usuario us = dameUsuario(usern, pass, tipoU);

		// si existe continuar el programa
		if (us != null) {

			System.out.println("");

			// mostrar los menus de cada usuario segun su instancia
			if (us instanceof Cliente) {
				Cliente cliente = (Cliente) (us);
				menuCliente(cliente);
			} else {

				Trabajador trabajador = (Trabajador) (us);
				menuTrabajador(trabajador);
			}
			// no mostrar el menu incial nuevamente
			continuarI = false;

			// si no existe avisar
		} else {

			System.out.println(
					"Lo sentimos, los datos que ingresaste no concuerdan con ningun usuario. Intenta de nuevo");
			System.out.println("");
			continuarI = true;
		}
		return continuarI;
	}

	/**
	 * metodo que retorna el usuario buscado segun su username y password para
	 * iniciar sesion
	 * 
	 * @param username,    nombre de usuario para el inicio de sesion
	 * @param password,    contraseña del usuario para el inicio de sesion
	 * @param tipoUsuario, tipo de usuario 1. Cliente 2. Trabajador
	 * @return us, retornar el usuario que coincide con la contraseña y nombre de
	 *         usuario segun su tipo de usuario
	 */
	public Usuario dameUsuario(String username, String password, int tipoUsuario) {

		// usuario encontrado a retornar
		Usuario us;
		// listas que almacena los usuarios diferenciados por sus instancias
		ArrayList<Usuario> clientes = new ArrayList<Usuario>();
		ArrayList<Usuario> trabajadores = new ArrayList<Usuario>();

		// validar si existen usuarios
		if (usuarios.size() == 0) {
			us = null;

			// si existen usuarios
		} else {

			// separar los usuarios por el su instancia
			for (int u = 0; u < usuarios.size(); u++) {

				if (usuarios.get(u) instanceof Cliente) {
					clientes.add(usuarios.get(u));
				} else {
					trabajadores.add(usuarios.get(u));
				}
			}

			// encontrar el usuario segun el tipo (1: cliente, 2: Trabajador)
			if (tipoUsuario == 1) {
				us = encontrarUsuario(clientes, username, password);

			} else {
				us = encontrarUsuario(trabajadores, username, password);
			}
		}
		return us;
	}

	/**
	 * metodo para buscar un usuario por su username y password
	 * 
	 * @param listaU,   lista de usuarios segun su tipo (Cliente o Trabajador)
	 * @param username, nombre de usuario para el inicio de sesion
	 * @param password, contraseña del usuario para el inicio de sesion
	 * @return usTemporal, usuario que coincide con el username y password ingresado
	 */
	public Usuario encontrarUsuario(ArrayList<Usuario> listaU, String username, String password) {

		// usuario temporal a retornar
		Usuario usTemporal = null;

		// buscar al usuario
		for (int n = 0; n < listaU.size(); n++) {

			// si el username coincide, seguir
			if (username.equals(listaU.get(n).getUsername())) {

				// si el password coincide, asignar a usTemporal el usuario validando
				if (password.equals(listaU.get(n).getPassword())) {
					usTemporal = listaU.get(n);
				}
			}
		}
		return usTemporal;
	}

	/**
	 * metodo que sirve para registrar un usuario al programa
	 */
	public void registrarUsuario() {

		// variables usadas para el ingreso de datos
		String nombre;
		String apellido;
		String direccion;
		String user;
		String pass;
		int tipoU;

		System.out.print("\nIngresa tu nombre: ");
		nombre = r.next();
		System.out.print("Ingresa tu apellido: ");
		apellido = r.next();
		System.out.print("Ingresa tu direccion: ");
		direccion = r.nextLine();
		direccion = r.nextLine();
		System.out.print("Ingresa tu username: ");
		user = r.nextLine();
		System.out.print("Ingresa tu password: ");
		pass = r.nextLine();

		tipoU = validarTipoUsuario();

		// crear un usuario y presentar sus funciones con su menu
		if (tipoU == 1) {

			Usuario cl = new Cliente(usuarios.size() + 1, nombre, apellido, direccion, user, pass);
			usuarios.add(cl);
			// realizar if para la instancia y mostrar sus menus

		} else {

			Usuario tr = new Trabajador(usuarios.size() + 1, nombre, apellido, direccion, user, pass);
			usuarios.add(tr);
			System.out.println(tr.getId());
			// realizar if para la instancia y mostrar sus menus

		}
	}

	/**
	 * metodo que sirve para pedir el tipo de instancia que tiene el usuario 1:
	 * cliente, 2: trabajador
	 */
	public int validarTipoUsuario() {

		// variable a retornar el valor identificador del tipo de usuario
		int tipoT = 0;
		// variable que permite identificar si hay mal ingreso de datos
		// true: hay mal ingreso de datos, false: no hay mal ingreso de datos
		boolean banderaT;

		// ciclo para pedir el tipo de usuario
		do {

			// verificar ingreso inadecuado de datos
			try {

				System.out.print("Ingresa el numero de usuario que eres (1) Cliente, (2) Trabajador: ");
				tipoT = r.nextInt();

				// la respuesta ingresada es un entero que no esta en las opciones
				if (tipoT == 1 || tipoT == 2) {

					banderaT = false;

				} else {

					System.out.println("La respuesta " + "\"" + tipoT + "\""
							+ " no esta dentro de las opciones permitidas. Intenta nuevamente");
					System.out.println("");
					banderaT = true;

				}

				// la respuesta ingresada no es un entero
			} catch (InputMismatchException e) {

				System.out.println(
						"La opcion ingresada no es valida, debe ingresar un numero entero. Intenta nuevamente");
				System.out.println("");
				r.nextLine();
				banderaT = true;

			}
		} while (banderaT);

		return tipoT;
	}

	/**
	 * metodo que muestra el menu de las funciones que puede realizar el cliente
	 * 
	 * @param cliente, cliente que inicia sesion
	 */
	public void menuCliente(Cliente cliente) {

		// variable para el ingreso de la opcion del usuario
		int respuesta_int;
		// variable para continuar el ciclo para mostrar menu
		boolean continuarC;

		System.out.println("======================================");
		System.out.println("	||Bienvenido " + cliente.getNombre() + "||");
		System.out.println("======================================");

		// mostrar menu
		do {
			// evaluando errores
			try {

				System.out.println(
						"\n1. Publicar Trabajo\n2. Ver estado de los trabajos\n3. Ver Trabajos publicados\n4. Ver trabajos con propuestas\n5. Ver trabajos finalizados\n6. Cerrar cuenta\n7. Salir");
				System.out.print("\nIngresa la opcion que desee: ");
				respuesta_int = r.nextInt();

				// se realiza la opcion que se ingreso
				switch (respuesta_int) {

				// primera opcion: publicar trabajo
				case 1:
					continuarC = true;
					publicarTrabajo(cliente);
					break;

				// segunda opcion: ver el estado de los trabajos
				case 2:
					continuarC = true;
					verEstadoTrabajo(cliente);
					break;

				// tercera opcion: ver Trabajos publicados
				case 3:
					continuarC = true;
					verTrabajosPublicados(cliente);
					System.out.println("");
					break;

				// cuarta opcion: ver trabajos con propuestas
				case 4:
					continuarC = true;
					// metodo
					System.out.println("");
					break;

				// quinta opcion: ver trabajos finalizados
				case 5:
					continuarC = true;
					// metodo
					System.out.println("");
					break;

				// sexta opcion: cerrar cuenta
				case 6:
					continuarC = true;
					// metodo
					System.out.println("");
					break;

				// septima opcion: salir del programa
				case 7:
					continuarC = false;
					System.out.println("======================================");
					System.out.println("       ||Saliste del programa||       ");
					System.out.println("======================================");
					System.out.println("");
					break;

				// no se ingreso los enteros permitidos para las opciones
				default:
					System.out.println("La respuesta " + "\"" + respuesta_int + "\""
							+ " no esta dentro de las opciones permitidas. Intenta nuevamente");
					continuarC = true;
				}

				// el usuario ingreso un dato diferente de int
			} catch (InputMismatchException e) {
				System.out.println(
						"La opcion ingresada no es valida, debe ingresar un numero entero. Intenta nuevamente");
				r.next();
				continuarC = true;
			}

		} while (continuarC);

		// opcion 5
		System.out.println("1. Ver propuestas de trabajadores\2. Cancelar trabajo\n3. Regresar");

		// opcion 3
		System.out.println("1. Cancelar trabajo\n2. Modificar trabajo\n3. Regresar");

		// opcion 5
		// colcoar primero los trabajos por pago
		System.out.println("1. Pagar trabajador\n2. Regresar");

	}

	/**
	 * metodo que permite publicar un trabajo
	 * 
	 * @param cl, cliente que realiza la publicacion de un trabajo
	 */
	public void publicarTrabajo(Cliente cl) {

		// variables para la publicacion de un trabajo
		String descripcion;
		String fechaInicio;
		String fechaFinal;
		float precio = 0;
		String estado = "espera";
		// variable que permite identificar si hay mal ingreso de datos
		// true: hay mal ingreso de datos, false: no hay mal ingreso de datos
		boolean banderaP;

		// ingreso de datos
		System.out.print("Ingresa la descripcion del trabajo: ");
		descripcion = r.nextLine();
		descripcion = r.nextLine();

		System.out.print("Ingresa la fecha en que se iniciara el trabajo (en el formato dia/mes/año): ");
		fechaInicio = r.next();

		System.out.print("Ingresa la fecha en que se finalizara el trabajo (en el formato dia/mes/año): ");
		fechaFinal = r.next();

		// ingreso adecuado para el precio del trabajo
		do {
			try {
				System.out.print("Ingresa el precio del trabajo: ");
				precio = r.nextFloat();
				banderaP = false;
			} catch (InputMismatchException e) {
				System.out.println("La opcion ingresada no es valida, debe ingresar un numero entero o decimal");
				System.out.println("");
				r.nextLine();
				banderaP = true;
			}

		} while (banderaP);

		// crear trabajo
		Trabajo trabajo = new Trabajo(descripcion, fechaInicio, fechaFinal, precio, estado);

		// añadir el trabajo a los trabajos publicados y a trabajos generales de cliente
		ArrayList<Trabajo> trabajoT = cl.getTrabajosPublicados();
		trabajoT.add(trabajo);
		cl.setTrabajosPublicados(trabajoT);
		cl.setTodosTrabajos(trabajoT);

		System.out.println("\nTu trabajo ha sido publicado");
		// opcional: crear una lista de trabajos y añadir el trabajo creado a esa lista

	}

	/**
	 * metodo que permite ver los estados de los trabajos
	 * 
	 * @param cl, cliente que realiza la publicacion de un trabajo
	 */
	public void verEstadoTrabajo(Cliente cl) {

		// lista de todos los trabajos del cliente
		ArrayList<Trabajo> trabajos = cl.getTodosTrabajos();

		for (int x = 0; x < trabajos.size(); x++) {

			// trabajo a utilizar
			Trabajo t = trabajos.get(x);

			System.out.println("Trabajo " + (x + 1) + ": ");
			System.out.println("	Descripcion: " + t.getDescripcion());
			System.out.println("	Estado: " + "\"" + t.getEstado() + "\"");

		}

	}

	/**
	 * metodo que permite ver los trabajos publicados
	 * 
	 * @param cl, cliente que realiza la publicacion de un trabajo
	 */
	public void verTrabajosPublicados(Cliente cl) {

		// lista de todos los trabajos del cliente
		ArrayList<Trabajo> trabajosP = cl.getTrabajosPublicados();

		for (int x = 0; x < trabajosP.size(); x++) {

			// trabajo a utilizar
			Trabajo t = trabajosP.get(x);

			System.out.println("Trabajo " + (x + 1) + ": ");
			System.out.println("	Descripcion: " + t.getDescripcion());
			System.out.println("	Estado: " + "\"" + t.getEstado() + "\"");

		}

	}

	/**
	 * metodo que muestra el menu de las funciones que puede realizar el trabajador
	 */
	public void menuTrabajador(Trabajador trabajador) {

		// un usuario debe tener trabajos colocar limites 1 solo trabajo o más
		// debe de ver los trabajos publicados por clientes
		// debe de poder proporcionar una oferta en el precioNegocio de Trabajo
		// debe de poder calificar cliente
	}

	// Getters y Setters
	/**
	 * @return usuarios, variable que almacena una lista de todos los usuarios
	 *         registrados en el programa
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios, variable que modifica el valor del atributo usuarios
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
