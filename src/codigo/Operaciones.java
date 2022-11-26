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

		} else {
			// profesion del trabajador
			String profesion;
			System.out.print("Ingresa tu profesion: ");
			profesion = r.nextLine();
			profesion = r.nextLine();

			Usuario tr = new Trabajador(usuarios.size() + 1, nombre, apellido, direccion, profesion, user, pass);
			usuarios.add(tr);

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

				// la respuesta ingresada es un entero esta en las opciones
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

	// Métodos para Cliente
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

				System.out.println("\n1. Publicar Trabajo\n2. Cancelar trabajo"
						+ "\n3. Ver estado de los trabajos\n4. Ver Trabajos publicados\n5. Ver trabajos con propuestas"
						+ "\n6. Pagar Trabajos\n7. Cerrar cuenta\n8. Salir");
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
					verTrabajosPropuesta(cliente);
					System.out.println("");
					break;

				// quinta opcion: ver trabajos por pagar
				case 5:
					continuarC = true;
					verTrabajosPagar(cliente);
					System.out.println("");
					break;

				// sexta opcion: cerrar cuenta
				case 6:
					continuarC = false;
					cerrarCuenta(cliente);
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
		Trabajo trabajo = new Trabajo(cl.getTodosTrabajos().size() + 1, descripcion, fechaInicio, fechaFinal, precio);

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

		// verificar si existen trabajos
		boolean existeT = existenTrabajos(trabajos);

		// si existen hacer el método si no, avisar que no hay trabajos publicados
		if (existeT) {

			for (int x = 0; x < trabajos.size(); x++) {

				// trabajo a utilizar
				Trabajo t = trabajos.get(x);

				System.out.println("\nTrabajo " + (x + 1) + ": ");
				System.out.println("	Descripcion: " + t.getDescripcion());
				System.out.println("	Estado: " + "\"" + t.getEstado() + "\"");

			}

		} else {

			System.out.println("No existen trabajos. Puedes introducir la opcion 1 para publicar un trabajo");

		}

	}

	/**
	 * metodo que permite ver los trabajos publicados
	 * 
	 * @param cl, cliente que realiza la publicacion de un trabajo
	 */
	public void verTrabajosPublicados(Cliente cl) {

		// lista de todos los trabajos publicados por el cliente
		ArrayList<Trabajo> trabajosP = cl.getTrabajosPublicados();

		// verificar si existen trabajos
		boolean existeT = existenTrabajos(trabajosP);

		if (existeT) {

			System.out.println("Los trabajos que has publicado son: \n");

			for (int x = 0; x < trabajosP.size(); x++) {

				// trabajo a utilizar
				Trabajo t = trabajosP.get(x);

				System.out.println("Trabajo " + (x + 1) + ": ");
				System.out.println("	Descripcion: " + t.getDescripcion());
				System.out.println("	Estado: " + "\"" + t.getEstado() + "\"");
				System.out.println("	Precio del trabajo: Q." + t.getPrecioInicio());
				System.out.println("	Fecha de publicacion: " + t.getFechaPublicacion());

			}

		} else {

			System.out.println("No existen trabajos. Puedes introducir la opcion 1 para publicar un trabajo");

		}

	}

	/**
	 * metodo que permite ver los trabajos que tiene propuestas de precio de los
	 * trabajadores
	 * 
	 * @param cl, cliente que realiza la publicacion de un trabajo
	 */
	public void verTrabajosPropuesta(Cliente cl) {

		// lista de todos los trabajos publicados por el cliente
		ArrayList<Trabajo> trabajosP = cl.getTrabajosPublicados();
		// lista de todos los trabajos que tienen precio de propuesta de trabajadores
		ArrayList<Trabajo> trabajosPropuesta = new ArrayList<Trabajo>();

		// obtener todos los trabajos con estado "realizando"
		for (int x = 0; x < trabajosP.size(); x++) {

			if ("espera".equals(trabajosP.get(x).getEstado())) {

				trabajosPropuesta.add(trabajosP.get(x));

			}
		}

		// verificar si existen trabajos
		boolean existeT = existenTrabajos(trabajosPropuesta);

		if (existeT) {

			System.out.println("Los trabajos con propuestas son: \n");

			for (int x = 0; x < trabajosPropuesta.size(); x++) {

				// trabajo a utilizar
				Trabajo t = trabajosPropuesta.get(x);

				System.out.println("Trabajo " + (x + 1) + ": ");
				System.out.println("	Datos del trabajo:");
				System.out.println("		Descripcion: " + t.getDescripcion());
				System.out.println("		Precio del trabajo: Q." + t.getPrecioInicio());
				System.out.println("");
				System.out.println("	Datos del Trabajador:");
				System.out.println(
						"		Nombre: " + t.getTrabajador().getNombre() + " " + t.getTrabajador().getApellido());
				System.out.println("		Profesion: " + t.getTrabajador().getProfesion());
				System.out.println("		Oferta por trabajo: Q." + t.getPrecioNegocio() + "\n");

				// calificaciones del trabajador
				ArrayList<Integer> calificaciones = t.getTrabajador().getCalificaciones();

				// calificacion promedio del trabajador
				float promedio = 0;

				// tamaño de la lista enviada
				int tamList = calificaciones.size();

				if (tamList == 0) {

					System.out.println("		Calificacion: No tiene calificacion disponible\n");

				} else {

					for (int c = 0; c < tamList; c++) {

						promedio += c;
					}

					System.out.println("		Calificacion: " + (promedio / tamList) + "\n");
				}
			}

			tomarOfertaTrabajador(trabajosPropuesta, cl);

		} else {

			System.out.println("No existen trabajos. Puedes introducir la opcion 1 para publicar un trabajo");

		}

	}

	/**
	 * metodo para preguntar si quiere aceptar o rechazar la oferta de trabajo del
	 * trabajador
	 * 
	 * @param listaP, lista con los trabajos que tienen una propuesta
	 */
	public void tomarOfertaTrabajador(ArrayList<Trabajo> listaP, Cliente cl) {

		// variable para el ingreso de la opcion del usuario
		int respuesta;
		// variable que permite seguir mostrando el menu
		// true: mostrar el menu nuevamente
		// false: no mostrar el menu nuevamente
		boolean continuar;

		// ciclo para mostrar menu
		do {

			// evaluar errores
			try {

				System.out.println("Ingresa la opcion que desees:");
				System.out.println("1. Aceptar oferta del trabajo\n2. Rechazar oferta del trabajo\n3. Salir");
				respuesta = r.nextInt();

				// aceptar trabajador
				if (respuesta == 1) {

					// obtener el id del trabajo a aceptar y cambiar estado
					int idT = dameIDTrabajo(listaP, cl);
					actualizarListas("realizando", idT, cl);
					System.out.println("Has aceptado la oferta de trabajo, el trabajo se esta realizando");

					continuar = false;

					// rechazar trabajador
				} else if (respuesta == 2) {

					// obtener el id del trabajo a rechazar y cambiar estado
					int idT = dameIDTrabajo(listaP, cl);
					actualizarListas("libre", idT, cl);
					System.out.println("Has rechazado la oferta de trabajo, nuevamente esta libre");
					continuar = false;

					// salir
				} else if (respuesta == 3) {

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
	 * metodo para obtener el id del trabajo
	 * 
	 * @param listaP, lista con los trabajos que tienen una propuesta
	 * @return indice, variable que contiene el indice del trabajo a eliminar o
	 *         rechazar
	 */
	public int dameIDTrabajo(ArrayList<Trabajo> listaP, Cliente cliente) {

		// variable a retornar que tiene el id del trabajo a eliminar o rechazar
		int id = 0;
		// cantidad de elementos de listaP
		int nelementos = listaP.size();
		// numero de trabajo a aceptar/rechazar
		int respuesta;
		// variable que permite identificar si hay mal ingreso de datos
		// true: hay mal ingreso de datos, false: no hay mal ingreso de datos
		boolean banderaT;

		// ciclo para pedir el tipo de usuario
		do {

			// verificar ingreso inadecuado de datos
			try {

				System.out.print("Ingresa el numero de trabajo: ");
				respuesta = r.nextInt();

				// la respuesta ingresada esta dentro de los numeros de los trabajos mostrados
				if ((respuesta > 0) && (respuesta <= nelementos)) {

					// indice del trabajo a aceptar
					id = listaP.get(respuesta - 1).getId();
					banderaT = false;

					// la respuesta ingresada no está dentro de los numeros de trabajos mostrados
				} else {

					System.out.println("La respuesta " + "\"" + respuesta + "\""
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

		return id;
	}

	/**
	 * metodo para actualizar las listas de cliente al aceptar o rechazar un
	 * trabajador
	 * 
	 * @param nuevoEstado, estado del trabajo a modificar
	 * @param id,          id del trabajo a modificar
	 * @param cl,          cliente que está realizando los cambios
	 */
	public void actualizarListas(String nuevoEstado, int id, Cliente cl) {

		// trabajo a actualizar
		Trabajo trabajo;

		// listas a actualizar en el cliente
		ArrayList<Trabajo> trabajosPublicados = cl.getTrabajosPublicados();
		ArrayList<Trabajo> trabajosEnCola = cl.getTrabajosEnCola();
		ArrayList<Trabajo> todosTrabajos = cl.getTodosTrabajos();

		// buscar el indice del trabajo a actualizar
		for (int x = 0; x < trabajosPublicados.size(); x++) {

			// si se encuentra realizar las modificaciones
			if (id == trabajosPublicados.get(x).getId()) {

				// cambiar estado
				trabajo = trabajosPublicados.get(x);
				trabajo.setPrecioFinal(trabajo.getPrecioNegocio());
				trabajo.setEstado(nuevoEstado);

				if (nuevoEstado.equals("realizando")) {

					// quitar de publicados y colocar en la lista en cola de clientes
					trabajosPublicados.remove(x);
					trabajosEnCola.add(trabajo);

					// setear las listas actualizadas
					cl.setTrabajosPublicados(trabajosPublicados);
					cl.setTrabajosEnCola(trabajosEnCola);

					// modificar la lista que guarda todos los trabajos
					for (int i = 0; i < todosTrabajos.size(); i++) {

						// si se encuentra realizar las modificaciones
						if (id == todosTrabajos.get(x).getId()) {

							// si se encuentra realizar las modificaciones
							todosTrabajos.remove(x);
							todosTrabajos.add(trabajo);

							// setear la lista actualizada
							cl.setTodosTrabajos(todosTrabajos);
						}
					}

				} else if (nuevoEstado.equals("libre")) {

					// quitar de publicados
					trabajosPublicados.remove(x);
					// setear las listas actualizadas
					cl.setTrabajosPublicados(trabajosPublicados);

					// modificar la lista que guarda todos los trabajos
					for (int i = 0; i < todosTrabajos.size(); i++) {

						// si se encuentra realizar las modificaciones
						if (id == todosTrabajos.get(x).getId()) {

							// si se encuentra realizar las modificaciones
							todosTrabajos.remove(x);
							todosTrabajos.add(trabajo);

							// setear la lista actualizada
							cl.setTodosTrabajos(todosTrabajos);

						}
					}
				}
			}
		}
	}

	/**
	 * metodo que se utiliza para verificar si existen trabajos en la clase cliente
	 * 
	 * @param listaT, lista de trabajos a verificar si existen trabajos
	 * @return banderaL, variable que identifica si existen o no trabajos en la
	 *         lista enviada; true: hay trabajos, false: no hay trabajos
	 */
	public boolean existenTrabajos(ArrayList<Trabajo> lisT) {

		// variable que identifica si hay trabajos en la lista enviada
		boolean banderaL;
		// tamaño de la lista enviada
		int tamList = lisT.size();

		// si existe o no trabajos en modificar banderaL
		if (tamList == 0) {

			banderaL = false;

		} else {

			banderaL = true;

		}
		return banderaL;
	}

	/**
	 * metodo para ver los trabajos por pagar
	 * 
	 * @param cl, cliente que realiza la publicacion de un trabajo
	 */
	public void verTrabajosPagar(Cliente cl) {

		// listas a actualizar
		ArrayList<Trabajo> trabajosEnCola = cl.getTrabajosEnCola();
		ArrayList<Trabajo> trabajosPagar = cl.getTrabajosPagar();

		// verificar si existen trabajos
		boolean existeT = existenTrabajos(trabajosPagar);

		// obtener todos los trabajos con estado "pago"
		for (int x = 0; x < trabajosEnCola.size(); x++) {

			if ("pago".equals(trabajosEnCola.get(x).getEstado())) {

				trabajosPagar.add(trabajosEnCola.get(x));
				trabajosEnCola.remove(trabajosEnCola.get(x));

			}
		}

		// actualizar la lista de trabajos por pagar
		cl.setTrabajosPagar(trabajosPagar);

		if (existeT) {

			System.out.println("Los trabajos que pendientes de pagos son: \n");

			for (int x = 0; x < trabajosPagar.size(); x++) {

				// trabajo a utilizar
				Trabajo t = trabajosPagar.get(x);

				System.out.println("Trabajo " + (x + 1) + ": ");
				System.out.println("	Datos del trabajo:");
				System.out.println("		Descripcion: " + t.getDescripcion());
				System.out.println("		Precio del trabajo: Q." + t.getPrecioFinal());
				System.out.println("");
				System.out.println("	Datos del Trabajador:");
				System.out.println(
						"		Nombre: " + t.getTrabajador().getNombre() + " " + t.getTrabajador().getApellido());
				System.out.println("		Profesion: " + t.getTrabajador().getProfesion());
			}

			// id del trabajo a pagar
			int id = dameIDTrabajo(trabajosPagar, cl);
			Trabajo trabajoC = pagarTrabajo("finalizado", id, cl);

			// calificar
			calificarUsuario(trabajoC);

			System.out.println("Has realizado el pago correspondiente");

		} else {

			System.out.println("No existen trabajos. Puedes introducir la opcion 1 para publicar un trabajo");

		}

	}

	/**
	 * metodo para actualizar las listas de cliente al pagar un trabajo
	 * 
	 * @param nuevoEstado, estado del trabajo a modificar
	 * @param id,          id del trabajo a modificar
	 * @param cl,          cliente que está realizando los cambios
	 */
	public Trabajo pagarTrabajo(String nuevoEstado, int id, Cliente cl) {

		// trabajo a actualizar
		Trabajo trabajo = null;

		// listas a actualizar en el cliente
		ArrayList<Trabajo> trabajosPagar = cl.getTrabajosPagar();
		ArrayList<Trabajo> trabajosFinal = cl.getTrabajosFinalizados();
		ArrayList<Trabajo> todosTrabajos = cl.getTodosTrabajos();

		// buscar el indice del trabajo a actualizar
		for (int x = 0; x < trabajosPagar.size(); x++) {

			// si se encuentra realizar las modificaciones
			if (id == trabajosPagar.get(x).getId()) {

				// cambiar estado
				trabajo = trabajosPagar.get(x);
				trabajo.setEstado(nuevoEstado);

				// quitar de publicados y colocar en la lista en cola de clientes
				trabajosPagar.remove(x);
				trabajosFinal.add(trabajo);

				// setear las listas actualizadas
				cl.setTrabajosPagar(trabajosPagar);
				cl.setTrabajosFinalizados(trabajosFinal);

				// modificar la lista que guarda todos los trabajos
				for (int i = 0; i < todosTrabajos.size(); i++) {

					// si se encuentra realizar las modificaciones
					if (id == todosTrabajos.get(x).getId()) {

						// si se encuentra realizar las modificaciones
						todosTrabajos.remove(x);
						todosTrabajos.add(trabajo);

						// setear la lista actualizada
						cl.setTodosTrabajos(todosTrabajos);
					}
				}
			}
		}
		return trabajo;
	}

	/**
	 * metodo para calificar a un trabajador
	 * 
	 * @param trabajoC, trabajo a pagar que contiene el trabajador a calificar
	 */
	public void calificarUsuario(Trabajo trabajoC) {

		// respuesta del usuario
		int respuesta;

		// variable que permite identificar si hay mal ingreso de datos
		// true: hay mal ingreso de datos, false: no hay mal ingreso de datos
		boolean banderaT;

		// ciclo para pedir el tipo de usuario
		do {

			// verificar ingreso inadecuado de datos
			try {

				System.out.println("Quieres calificar a un usuario (1. Si), (2. No)");
				respuesta = r.nextInt();

				// la respuesta ingresada es un entero esta en las opciones
				if (respuesta == 1) {

					// respuesta del usuario
					int respuesta2;

					// variable que permite identificar si hay mal ingreso de datos
					// true: hay mal ingreso de datos, false: no hay mal ingreso de datos
					boolean banderaT2;

					// ciclo para pedir el tipo de usuario
					do {

						// verificar ingreso inadecuado de datos
						try {

							System.out.println("Ingresa un valor entre 1 y 5 para calificar a " + "\""
									+ trabajoC.getTrabajador().getNombre() + "\"");
							respuesta2 = r.nextInt();

							// si ingresa un valor válido, calificar
							if (respuesta2 >= 1 && respuesta2 <= 5) {

								ArrayList<Integer> calificacion = trabajoC.getTrabajador().getCalificaciones();
								calificacion.add(respuesta2);
								trabajoC.getTrabajador().setCalificaciones(calificacion);

								System.out.println("Has calificado al trabajador " + "\""
										+ trabajoC.getTrabajador().getNombre() + "\"");

								banderaT2 = false;

							} else {

								System.out.println("La respuesta " + "\"" + respuesta2 + "\""
										+ " no esta dentro de las opciones permitidas. Intenta nuevamente");
								System.out.println("");

								banderaT2 = true;
							}

						} catch (InputMismatchException e) {

							System.out.println(
									"La opcion ingresada no es valida, debe ingresar un numero entero. Intenta nuevamente");
							System.out.println("");
							r.nextLine();
							banderaT2 = true;

						}
					} while (banderaT2);

					banderaT = false;

				} else if (respuesta == 2) {

					banderaT = false;

				} else {

					System.out.println("La respuesta " + "\"" + respuesta + "\""
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

	}

	/**
	 * metodo para cerrar cuenta de usuario
	 * 
	 * @param u, usuario para eliminar de la lista de usuarios (cerrar cuenta)
	 */
	public void cerrarCuenta(Usuario u) {

		// eliminar al usuario enviado mediante su id
		if (u instanceof Cliente) {

			Cliente cl = (Cliente) (u);

			int id = cl.getId();

			for (int x = 0; x < usuarios.size(); x++) {

				if (id == usuarios.get(x).getId()) {

					System.out.println("Gracias por usar nuestro programa " + usuarios.get(x).getNombre());

					usuarios.remove(x);

				}
			}

		} else {

			Trabajador tr = (Trabajador) (u);

			int id = tr.getId();

			for (int x = 0; x < usuarios.size(); x++) {

				if (id == usuarios.get(x).getId()) {

					System.out.println("Gracias por usar nuestro programa " + usuarios.get(x).getNombre());

					usuarios.remove(x);

				}
			}
		}

	}

	// Metodos para Trabajador
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
