//Cliente es una clase hija de usuario, este objeto sirve para crear clientes que solicitaran un servicio dentro del programa
import java.util.ArrayList;
public class Cliente extends Usuario{
    // "Trabajo" es una clase que será agregada para la entrega final, por el momento no existe, y es una clase donde se especifica el trabajo acordado por el cliente y el trabajador
    private Trabajo trabajo;
    private ArrayList<Trabajo> trabajosp;
    private ArrayList<Trabajo> trabajosc;
    private ArrayList<Trabajo> trabajosEnCola;

    public Cliente(){
        super();
    }
    
    public Cliente(String nombre, String direccion, ArrayList<String> valoraciones, float dinero, Trabajo trabajo, ArrayList<Trabajo> trabajosp, ArrayList<Trabajo> trabajosc, ArrayList<Trabajo> trabajosEnCola){
        super(nombre, direccion, valoraciones, dinero);
        this.trabajo = trabajo;
        this.trabajosp = trabajosp;
        this.trabajosc = trabajosc;
        this.trabajosEnCola = trabajosEnCola;
    }
    
    public void publicarTrabajo(Trabajo trabajo){
        // Por el momento los atributos para crear el trabajo no están disponibles pues no existe el objeto "Trabajo"
        // Este método nos permite crear un "Trabajo" y guardarlo en una lista de trabajos publicados por el cliente
        Trabajo trabajo1 = new Trabajo(cliente, trabajador, profesion, descripcion, precioC, precioT, precioF, estado);
        trabajosp.add(trabajo1);
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }
    public ArrayList<Trabajo> getTrabajosp() {
        return trabajosp;
    }
    public void setTrabajosp(ArrayList<Trabajo> trabajosp) {
        this.trabajosp = trabajosp;
    }
    public ArrayList<Trabajo> getTrabajosc() {
        return trabajosc;
    }
    public void setTrabajosc(ArrayList<Trabajo> trabajosc) {
        this.trabajosc = trabajosc;
    }
    public ArrayList<Trabajo> getTrabajosEnCola() {
        return trabajosEnCola;
    }
    public void setTrabajosEnCola(ArrayList<Trabajo> trabajosEnCola) {
        this.trabajosEnCola = trabajosEnCola;
    }

}
