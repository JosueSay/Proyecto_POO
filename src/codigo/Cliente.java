package codigo;

import java.util.ArrayList;

public class Cliente extends Usuario{

	// Atributos
	private ArrayList<Trabajo> trabajosPublicados = new ArrayList <Trabajo>();
	private ArrayList<Trabajo> trabajosEnCola = new ArrayList <Trabajo>();
	private ArrayList<Trabajo> trabajosFinalizados = new ArrayList <Trabajo>();
	
	// Constructor
	public Cliente(int id, String nombre, String apellido, String direccion, String username, String password) {
		super(id, nombre, apellido, direccion, username, password);
		
	}
	
	// Getters y Setters
	public ArrayList<Trabajo> getTrabajosPublicados() {
		return trabajosPublicados;
	}

	public void setTrabajosPublicados(ArrayList<Trabajo> trabajosPublicados) {
		this.trabajosPublicados = trabajosPublicados;
	}

	public ArrayList<Trabajo> getTrabajosEnCola() {
		return trabajosEnCola;
	}

	public void setTrabajosEnCola(ArrayList<Trabajo> trabajosEnCola) {
		this.trabajosEnCola = trabajosEnCola;
	}

	public ArrayList<Trabajo> getTrabajosFinalizados() {
		return trabajosFinalizados;
	}

	public void setTrabajosFinalizados(ArrayList<Trabajo> trabajosFinalizados) {
		this.trabajosFinalizados = trabajosFinalizados;
	}

}
