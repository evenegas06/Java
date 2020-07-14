
package practica3;

import java.util.ArrayList;

public class IniciarClientes {
    
    public static void main(String[] args) {
        
        ArrayList<Cliente> clientes= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            clientes.add(new Cliente());
        }
        for (Cliente cliente : clientes) {
            cliente.start();
        }
    }
}
