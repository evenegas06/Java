package proyectobatallanaval;

import java.io.*;
import java.net.*;

public class MiSocketDatagrama extends DatagramSocket {

    static final int MAX_LON = 10;

    public MiSocketDatagrama(int numpuerto) throws SocketException {
        super(numpuerto);
    }

    public void enviamesaje(InetAddress maquinareceptora, int puetoreceptor, String mensaje) throws IOException {
        byte[] almacenenvio = mensaje.getBytes();
        DatagramPacket datagrama = new DatagramPacket(almacenenvio, almacenenvio.length, maquinareceptora, puetoreceptor);
        this.send(datagrama);
    }

    public String recibirmensaje() throws IOException {
        byte[] almacenrecepcion = new byte[MAX_LON];
        DatagramPacket datagrama = new DatagramPacket(almacenrecepcion, MAX_LON);
        this.receive(datagrama);
        String mensaje = new String(almacenrecepcion);
        return mensaje;
    }
}
