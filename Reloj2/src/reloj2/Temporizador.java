package reloj2;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Temporizador extends Thread {

    private final JLabel label;
    private final JButton inicio;
    private int hrs, min, seg;
    private boolean estado;
   

    public Temporizador(JLabel label, int hrs, int min, int seg, JButton inicio) {
        this.hrs = hrs;
        this.min = min;
        this.seg = seg;
        this.label = label;
        this.inicio = inicio;
    
    }

    @Override
    public void run() {
        //int cccc = 0;
        //    while (true) {
        System.out.println();
        try {
            while (estado) {

                if (seg != 0) {//si no es el ultimo segundo
                    seg--;  //decremento el numero de segundos                                  
                } else {
                    if (min != 0) {//si no es el ultimo minuto
                        seg = 59;//segundos comienzan en 59
                        min--;//decremento el numero de minutos
                    } else {
                        if (hrs != 0) {
                            hrs--;//decremento el numero de horas
                            min = 59;//minutos comienzan en 59
                            seg = 59;//segundos comienzan en 59
                        } else {
                            inicio.setText("Habilitar");
                            
                            break;//seacabo el tiempo fin hilo  
                        }
                    }
                }

                String segundos, minutos, hora;

                hora = hrs < 10 ? String.valueOf("0" + hrs) : String.valueOf(hrs);
                segundos = seg < 10 ? String.valueOf("0" + seg) : String.valueOf(seg);
                minutos = min < 10 ? String.valueOf("0" + min) : String.valueOf(min);

                label.setText(hora + " : " + minutos + " : " + segundos);
                if (hrs == 0 && min == 0 && seg == 0) {
                    Sonido.MIN.play();
                   
                }
                Thread.sleep(1000);
               // System.out.println(cccc++);
            }

        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }

        // }
        //  Sonido.MIN.play();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void reiniciar() {
        hrs = min = seg = 0;
        label.setText("00 : 00 : 00");

    }
    
   

    
}
