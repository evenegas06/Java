package reloj2;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JLabel;

public class Reloj extends Thread {

    private int hrs, min, seg, dia, mes, anio;
    private final JLabel labelH, labelF;
    private boolean estado;
    private ArrayList alarmas;
    String alarmaA;

    private String zona;
    Calendar hora;

    public Reloj(JLabel labelH, JLabel labelF) {
        this.labelH = labelH;
        this.labelF = labelF;

    }

    @Override
    public void run() {
        try {
            while (estado) {

                fecha2();

                hora();
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println(":'(");
        }
    }

    public void fecha2() {
        if (zona != null) {
            hora = Calendar.getInstance(TimeZone.getTimeZone(zona));
        } else {
            hora = Calendar.getInstance();
            zona = hora.getTimeZone().getID();
        }
        dia = hora.get(Calendar.DAY_OF_MONTH);
        mes = hora.get(Calendar.MONTH) + 1;
        anio = hora.get(Calendar.YEAR);

        String di, ms, an;

        di = dia < 10 ? String.valueOf("0" + dia) : String.valueOf(dia);
        ms = mes < 10 ? String.valueOf("0" + mes) : String.valueOf(mes);
        an = anio < 10 ? String.valueOf("0" + anio) : String.valueOf(anio);

        labelF.setText(di + "/" + ms + "/" + an);

    }

    public void hora() {
        if (zona != null) {
            hora = Calendar.getInstance(TimeZone.getTimeZone(zona));
        } else {
            hora = Calendar.getInstance();
            zona = hora.getTimeZone().getID();
        }

        hrs = hora.get(Calendar.HOUR);
        min = hora.get(Calendar.MINUTE);
        seg = hora.get(Calendar.SECOND);

        String segundos, minutos, horas;

        horas = hrs < 10 ? String.valueOf("0" + hrs) : String.valueOf(hrs);
        segundos = seg < 10 ? String.valueOf("0" + seg) : String.valueOf(seg);
        minutos = min < 10 ? String.valueOf("0" + min) : String.valueOf(min);

        labelH.setText(horas + " : " + minutos + " : " + segundos);
        alarmaA = hora + minutos + segundos;

        //* ALARMA *///
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList getAlarmas() {
        return alarmas;
    }

    public void addAlarma(String al) {
        alarmas.add(al);

    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
