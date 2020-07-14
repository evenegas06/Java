package organizacionarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManejoArchivos {

    public boolean guardarA(String name, String texto) {
        try {
            BufferedWriter salida = new BufferedWriter(new FileWriter(name));
            salida.write(texto);
            salida.flush();
            salida.close();
            return true;

        } catch (IOException ex) {
            return false;
        }
    }

    public String abrirA(String name) {
        String cad = "";
        try {
            FileInputStream entrada = new FileInputStream(name);
            byte doc[] = new byte[entrada.available()];
            entrada.read(doc);
            cad = new String(doc);
            entrada.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cad;
    }

    public String leerArchivo(String nombreArchivo) {
        String texto = "";
        FileReader lectorArchivo = null;
        String linea = "";

        try {
            lectorArchivo = new FileReader(nombreArchivo);
            BufferedReader lectorMemoria = new BufferedReader(lectorArchivo);

            while ((linea = lectorMemoria.readLine()) != null) {

                texto = linea;
            }

        } catch (FileNotFoundException e) {
            // System.out.println("Archivo no Encontrado");
        } catch (IOException e) {
            //System.out.println("Ocurrio un error de entrada/Salida");
        } finally {
            if (lectorArchivo != null) {
                try {
                    lectorArchivo.close();

                } catch (IOException e) {
                    //      System.out.println("Error al crear Archivo");
                }
            }
        }
        return texto;
    }

    public void crearCarpeta(String name) {
        String ruta = "C:" + File.separator + name;
        File dir = new File(ruta); //crear carpeta
        dir.mkdir();
    }

    public void escribirArchivo(String ruta, String tex) {
        try {

            FileWriter w = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            wr.write(tex);//escribimos en el archivo

            wr.close();
            bw.close();

        } catch (IOException e) {
        }
    }
}
