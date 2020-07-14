package organizacionarchivos;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("C:" + File.separator +"EditorTexto");
        
        
        ManejoArchivos c = new ManejoArchivos();
        if (!f.exists()) {
             c.crearCarpeta("EditorTexto");
        }
       

        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Editor de texto v1");
    }
}
