package proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {
    

    Socket socket;
    DataOutputStream salida;
    DataInputStream entrada;
    String ipServidor = "127.0.0.1";
    int puerto = 6066;
    int tipo;
    String accion;
    String noCuenta;
    
    public Cliente(int tipo, String accion){
        this.accion=accion;
        this.tipo=tipo;
        //this.noCuenta=noCuenta;
        
    }

    @Override
    public void run() {
        try {
            socket = new Socket(ipServidor, puerto);
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            salida.writeInt(tipo);
            salida.writeUTF(accion);
            System.out.println("Servidor dijo: " + entrada.readUTF());

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
}
