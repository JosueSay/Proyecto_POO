package codigo;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Usuario> pruebaU = new ArrayList<Usuario>();

		Usuario u1 = new Cliente(1, "josue", "say", "03-ap-p", "jos1", "admin");
		pruebaU.add(u1);
		
		
		Operaciones op = new Operaciones();

		op.setUsuarios(pruebaU);
		
		op.menuInicial();

	}

}
