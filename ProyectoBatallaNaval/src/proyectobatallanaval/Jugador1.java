
package proyectobatallanaval;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Jugador1 {

    public static void main(String[] args) {

        String ip = "";
        String nombreHost = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            nombreHost = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            System.err.println("error");
        }
    

        int puertoReceptor = 2224;
        int miPuerto = 2223;

        String ipRival = JOptionPane.showInputDialog(null, "Ip del Adversario: ", nombreHost + " IP: " + ip, JOptionPane.WARNING_MESSAGE);
        Tablero tablero = new Tablero(ipRival, puertoReceptor, miPuerto);
        
        P1 p1 = new P1(tablero);
        p1.setVisible(true);
        p1.setResizable(false);

    }
}
