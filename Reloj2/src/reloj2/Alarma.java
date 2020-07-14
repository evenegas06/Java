package reloj2;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;


public class Alarma extends Thread {

    private int hrs, min, seg, tiempo;
    private final JLabel labelH;
    private boolean estado;

    String alarmaA;
    private int tipo;

    Calendar hora;
    ArrayList<Alarmas> alr = new ArrayList<>();
   

    public Alarma(JLabel labelH, ArrayList<Alarmas> alr) {
        this.alr = alr;
        this.labelH = labelH;

    
    }

    public void run() {
        try {
            while (estado) {

                hora();
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println(":'(");
        }

    }

    public void hora() {

        hora = Calendar.getInstance();

        hrs = hora.get(Calendar.HOUR);
        min = hora.get(Calendar.MINUTE);
        seg = hora.get(Calendar.SECOND);
        tiempo = hora.get(Calendar.AM_PM);

        String segundos, minutos, horas, t;

        horas = hrs < 10 ? String.valueOf("0" + hrs) : String.valueOf(hrs);
        segundos = seg < 10 ? String.valueOf("0" + seg) : String.valueOf(seg);
        minutos = min < 10 ? String.valueOf("0" + min) : String.valueOf(min);
        t = tiempo == 1 ? "PM" : "AM";

        labelH.setText(horas + " : " + minutos + " : " + segundos + " " + t);
        for (Alarmas alr1 : alr) {
            if (alr1.getHora() == hrs && alr1.getMin() == min && alr1.getAmPm().equals(t)) {
                Sonido.MIN.play();

            }
        }
        //* ALARMA *///
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    public void reiniciar() {
        hrs = min = seg = 0;
        labelH.setText("00 : 00 : 00");
        alr.clear();

    }
}
