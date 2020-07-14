package practica3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {

    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int idSesionAtendida;

    public ServidorHilo(Socket socket, int idSesionAtendida) {

        this.socket = socket;
        this.idSesionAtendida = idSesionAtendida;

        try {
            entrada = new DataInputStream(this.socket.getInputStream());
            salida = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException ex) {
            System.err.println("error IO");
        }
    }

    private void desconectar() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            int contador = entrada.readInt();
            System.out.println("Cliente con Sesion " + this.idSesionAtendida + "Solicito contar hasta  " + contador);

            for (int i = 0; i <= contador; i++) {
                System.out.println("sesion: " + this.idSesionAtendida + " " + i);
                Thread.sleep(1000);
            }

            salida.writeUTF("Tu sesion " + this.idSesionAtendida + "Ha finalizado");

        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
    }

}
