package proyectobatallanaval;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Jugador2 {

    public static void main(String[] args) {

        String ip = "";
        String nombreHost = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            nombreHost = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            System.err.println("error");
        }

        int puertoReceptor = 2223;
        int miPuerto = 2224;

        String ipRival = JOptionPane.showInputDialog(null, "Ip del Adversario: ", nombreHost + " IP: " + ip, JOptionPane.WARNING_MESSAGE);
        Tablero tablero = new Tablero(ipRival, puertoReceptor, miPuerto);
        
        P2 p2 = new P2(tablero);
        p2.setVisible(true);
        p2.setResizable(false);

    }
}
