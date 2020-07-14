package tarea3archivosdirectos;

import java.io.File;
import vista.Principal;

public class Main {

    public static void main(String[] args) {

        File f = new File("C:" + File.separator + "ArchivosDirectos"); //Carpeta Archivos Directos
        File f2 = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes"); //Carpeta Imagenes dentro de Archivos Directos

        ManejoArchivos c = new ManejoArchivos(); //Objeto Archivos
        
        if (!f.exists()) {  // Verifica si la carpeta Archivos Directos ya existe "No existe f?"
            c.crearCarpeta("C:" + File.separator + "ArchivosDirectos");
            c.crearCarpeta("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes");
        }

        Controlador controlador = new Controlador();
        Principal ventanaPrincipal = new Principal(controlador);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
}
