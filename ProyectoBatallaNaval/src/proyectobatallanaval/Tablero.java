package proyectobatallanaval;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

public class Tablero {

    private Target t1;
    private Target t2;
    private Target t3;

    private String maquinaReceptora;
    private int puertoReceptor;
    private int miPuerto;

    private String matrizTablero[][];

    private int ataqueRecibidosAcertados = 0;
    private int ataqueLanzadosAcertados = 0;

    MiSocketDatagrama miSocket;

    public Tablero(String maquinaReceptora, int puertoReceptor,
            int miPuerto) {

        this.maquinaReceptora = maquinaReceptora;
        this.puertoReceptor = puertoReceptor;
        this.miPuerto = miPuerto;

        try {
            miSocket = new MiSocketDatagrama(miPuerto);
        } catch (SocketException ex) {
            System.err.println("Error al crear socket");
        }
    }

    public String[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(String[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

    public String getMaquinaReceptora() {
        return maquinaReceptora;
    }

    public void setMaquinaReceptora(String maquinaReceptora) {
        this.maquinaReceptora = maquinaReceptora;
    }

    public int getPuertoReceptor() {
        return puertoReceptor;
    }

    public void setPuertoReceptor(int puertoReceptor) {
        this.puertoReceptor = puertoReceptor;
    }

    public int getMiPuerto() {
        return miPuerto;
    }

    public void setMiPuerto(int miPuerto) {
        this.miPuerto = miPuerto;
    }

    public void setT1(Target t1) {
        this.t1 = t1;
    }

    public void setT2(Target t2) {
        this.t2 = t2;
    }

    public void setT3(Target t3) {
        this.t3 = t3;
    }

    public int getAtaqueRecibidosAcertados() {
        return ataqueRecibidosAcertados;
    }

    public int getAtaqueLanzadosAcertados() {
        return ataqueLanzadosAcertados;
    }

    public void setAtaqueRecibidosAcertados() {
        this.ataqueRecibidosAcertados++;
    }

    public void setAtaqueLanzadosAcertados() {
        this.ataqueLanzadosAcertados++;
    }

    public void crearTablero() {
        matrizTablero = new String[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrizTablero[i][j] = "*";
            }
        }

        matrizTablero[t1.getCoordenadaX()][t1.getCoordenadaY()] = "T";
        matrizTablero[t2.getCoordenadaX()][t2.getCoordenadaY()] = "T";
        matrizTablero[t3.getCoordenadaX()][t3.getCoordenadaY()] = "T";

    }

    public void modificarTablero(String signo, int x, int y) {
        matrizTablero[x][y] = signo;
    }

    public void lanzarAtaque(String msj) {

        try {
            InetAddress direccionMaquinaReceptora
                    = InetAddress.getByName(maquinaReceptora);
            miSocket.enviamesaje(direccionMaquinaReceptora,
                    puertoReceptor, msj);

        } catch (Exception ex) {

        }
    }

    public String recibirMensaje() {
        try {
            return miSocket.recibirmensaje();
        } catch (IOException ex) {
            return "";
        }
    }

    public boolean recibirAtaque() {
        try {
            String msj = miSocket.recibirmensaje();

            String coordenadas[] = msj.split(",");
            int x = Integer.parseInt(coordenadas[0].trim());
            int y = Integer.parseInt(coordenadas[1].trim());

            if (t1.getCoordenadaX() == x && t1.getCoordenadaY() == y) {
                modificarTablero("A", x, y);
                return true;
            } else if (t2.getCoordenadaX() == x && t2.getCoordenadaY() == y) {
                modificarTablero("A", x, y);
                return true;
            } else if (t3.getCoordenadaX() == x && t3.getCoordenadaY() == y) {
                modificarTablero("A", x, y);
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public void mostrarTablero() {

        System.out.print("  ");
        for (int header = 0; header < 10; header++) {
            System.out.print(header + "\t");
        }
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(matrizTablero[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
