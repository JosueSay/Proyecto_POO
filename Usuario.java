/*  Gustavo Cruz        #22779  
 *  Josué Say           #22801
 *  Javier Chen         #22153
 * 
 * 
 */
import java.util.ArrayList;
public class Usuario {
    protected String nombre;
    protected String direccion;
    protected ArrayList<String> valoraciones;
    protected float dinero;

    public Usuario(){

    }

    public Usuario(String nombre, String direccion, ArrayList<String> valoraciones, float dinero){
        this.nombre = nombre;
        this.direccion = direccion;
        this.valoraciones = valoraciones;
        this.dinero = dinero;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(ArrayList<String> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public ArrayList<String> obtenerVBuenas(ArrayList<String> valoraciones){
        
        return valoraciones;
    }

    public int calificarUsuario(ArrayList<String> valBuenas, ArrayList<String> valoraciones ){
        int a = 0;
        if(valBuenas.size() > 0 & valoraciones.size() > 0){
            a = 1;
        }
        else
        if(valbuenas.size() == 0 & valoraciones.size() > 0){
            a = 0;
        }
        return a;
    }

}
