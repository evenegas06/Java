package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        try {
            String ipServidor = "127.0.0.1";
            int puerto = 12345;

            Socket socketCliente = new Socket(ipServidor, puerto);
            System.out.println("Conectado a :" + socketCliente.getRemoteSocketAddress());

            DataOutputStream dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
            dataOutputStream.writeUTF("Gracias por aceptar mi conexion" + socketCliente.getLocalSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socketCliente.getInputStream());
            System.out.println("Servidor dijo " + dataInputStream.readUTF());

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
