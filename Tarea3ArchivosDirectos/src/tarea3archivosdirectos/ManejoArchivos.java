package tarea3archivosdirectos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ManejoArchivos {

    public void crearCarpeta(String name) {
        File dir = new File(name); //crear carpeta
        dir.mkdir();
    }

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

        } catch (Exception e) {
            // System.out.println("Error Archivo");
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

    public void copy(File src, File dist) {
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dist);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

        } catch (IOException ex) {

        }
        
        
        
    }

    public void copiarDirectorios(File d1, File d2) {
        // Comprobamos que es un directorio
        if (d1.isDirectory()) {
            //Comprobamos si existe el directorio destino, si no lo creamos
            if (!d2.exists()) {
                d2.mkdir();
            }
            // Sacamos todos los ficheros del directorio
            String[] ficheros = d1.list();

            for (int x = 0; x < ficheros.length; x++) {
// Por cada fichero volvemos a llamar recursivamente a la copa de directorios
                String bb = ficheros[x];
                int p = bb.lastIndexOf(".");

                if (p != -1) {
                    String ex = bb.substring(p);
                    
                    copiarDirectorios(new File(d1, ficheros[x]), new File(d2, bb));
                } else {
                    String ex = "";
                    
                    copiarDirectorios(new File(d1, ficheros[x]), new File(d2, bb));

                }
            }
        } else {
            copy(d1, d2);
        }
    }
    
    
    public static void borrarDirectorio(File directorio) {
        File[] ficheros = directorio.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            if (ficheros[x].isDirectory()) {
                borrarDirectorio(ficheros[x]);
            }
            ficheros[x].delete();
        }
    }
    
    
    
    
 
    public void listarArchivos(File p) {
       // System.out.println(p.getAbsolutePath());//imprime la ruta//
        //System.out.println(p.getName());//imprimir el puro nombre//

        File ars[] = p.listFiles();//agrega  el metodo//
        String[] nomArchivos;
        for (File f : ars) {

            System.out.println("\t" + f.getName());
        }
    }

}
