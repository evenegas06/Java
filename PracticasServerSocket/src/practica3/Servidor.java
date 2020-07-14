package practica3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        try {
            int puerto = 6066;
            ServerSocket serverSocket = new ServerSocket(puerto);
           // serverSocket.setSoTimeout(3000);
            System.out.println("Servidor iniciado");
            int idSesiones = 1;

            while (true) {
                Socket socket;
                socket = serverSocket.accept();

                new ServidorHilo(socket, idSesiones).start();
               // ServidorHilo sh = new ServidorHilo(socket, idSesiones);
               // sh.start();
                idSesiones++;
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
