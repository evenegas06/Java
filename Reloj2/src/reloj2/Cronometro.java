package reloj2;

import javax.swing.JLabel;


public class Cronometro extends Thread {

    private boolean estado;
    private final JLabel cro;
    private int hrs = 0, min = 0, seg = 0, ds = 0;

    public Cronometro(JLabel cro) {
        this.cro = cro;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println();
            while (estado) {
                try {
                    // while (true) {
                   if (ds == 99) {
                     ds = 0;
                     seg++;
                     }
                     if (seg == 59) {
                     seg = 0;
                     min++;
                     }
                     if (min == 59) {
                     min = 0;
                     hrs++;
                     }
                     ds++;
                 

                    String segundos, minutos, hora, decimas;

                    hora = hrs < 10 ? String.valueOf("0" + hrs) : String.valueOf(hrs);
                    segundos = seg < 10 ? String.valueOf("0" + seg) : String.valueOf(seg);
                    minutos = min < 10 ? String.valueOf("0" + min) : String.valueOf(min);
                    decimas = ds < 10 ? String.valueOf("0" + ds) : String.valueOf(ds);

                    cro.setText(hora + " : " + minutos + " : " + segundos + " : " + decimas);

                    Thread.sleep(10);
                    //   }
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void reiniciar() {
        hrs = min = seg = ds = 0;
        cro.setText("00 : 00 : 00 : 00");
    }

}
