public class Trabajador extends Usuario{
    private float precio_trabajador;

    public Trabajador(){
        super();
    }

    public Trabajador(String nombre, String direccion, ArrayList<String> valoraciones, float dinero, float precio_trabajador){
        super(nombre, direccion, valoraciones, dinero);
        this.precio_trabajador = precio_trabajador;
    }
    //PrecioF es un atributo de la clase trabajo la cual es el precio acordado por el cliente y el trabajador
    public String cobrar(float precioF){
        return "\nEl monto de dinero a cobrar es: "+ precioF;
    }

    public float getPrecio_trabajador() {
        return precio_trabajador;
    }

    public void setPrecio_trabajador(float precio_trabajador) {
        this.precio_trabajador = precio_trabajador;
    }

}
