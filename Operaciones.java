import java.util.ArrayList;
public class Operaciones {
    private ArrayList<Usuario> usuarios;
    private Usuario usario;

    public Operaciones(){

    }

    public Operaciones(ArrayList<Usuario> usuarios, Usuario usuario){
        this.usuario = usuario;
        this.usuarios = usuarios;
    }

    public String abrirCuenta(Usuario usuario){
        Usuario usuario1 = new Usuario(nombre, direccion, valoraciones, dinero);
        usuarios.add(usuario1);
        return "Cuenta registrada" + usuario1;
    }

    public String cerrarCuenta(int x){
        int xi = x;
        usuarios.remove(xi);
        return "El cliente en la posicion: " + x + " ha sido eliminado";
    }

    

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Usuario getUsario() {
        return usario;
    }
    public void setUsario(Usuario usario) {
        this.usario = usario;
    }


}
