package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {

    private ServerSocket serverSocket;

    public Servidor(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Esperando clientes en el puerto: " + serverSocket.getLocalPort());
                Socket socketDatos = serverSocket.accept();

                System.out.println("Conexion aceptada de : " + socketDatos.getRemoteSocketAddress());

                for (int i = 0; i < 10; i++) {
                    System.out.println("Esperando..." + i);
                    Thread.sleep(1000);
                }

                DataInputStream dataInputStream = new DataInputStream(socketDatos.getInputStream());

                System.out.println("Mensaje del cliente: " + dataInputStream.readUTF());

                DataOutputStream dataOutputStream = new DataOutputStream(socketDatos.getOutputStream());
                dataOutputStream.writeUTF("Se conecto a: " + socketDatos.getLocalSocketAddress());

                socketDatos.close();
            } catch (Exception ex) {

            }
        }

    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor(12345);
            servidor.start();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
