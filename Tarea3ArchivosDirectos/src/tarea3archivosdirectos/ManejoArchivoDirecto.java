package tarea3archivosdirectos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoArchivoDirecto {

    private RandomAccessFile archivo;

    public RandomAccessFile getArchivo() {
        return archivo;
    }

    public void setArchivo(RandomAccessFile archivo) {
        this.archivo = archivo;
    }

    public void abrirArchivo(String nombreArchivo) {
        try {
            archivo = new RandomAccessFile(nombreArchivo, "rw");
            System.out.println("archivo abierto");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivoDirecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    public void cerrarArchivo() {
        if (archivo != null) {
            try {
                System.out.println("Tamaño Archivo: " + archivo.length());
                archivo.close();
                System.out.println("archivo cerrado");
                
            } catch (IOException ex) {
             // Logger.getLogger(ManejoArchivoDirecto.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("no se cerro");
            }
        }
    }

    /*public String leerCadena(int pos, int tam) throws IOException {
        // archivo = new RandomAccessFile("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat", "r");
        abrirArchivo("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
        byte buffer[] = new byte[tam];
        archivo.seek(pos);
        archivo.read(buffer);
        archivo.close();
        return new String(buffer);
    }
    */
    public String leerCadena(int tam) throws IOException {
     byte buffer[] = new byte[tam];
     archivo.read(buffer);

     return new String(buffer);
    }

   /* public int leerInt(int pos) throws IOException {
        //  archivo = new RandomAccessFile("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat", "r");
        abrirArchivo("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
        archivo.seek(pos);
        int a = archivo.readInt();
        String tamaño = String.valueOf(a);
        archivo.close();
        return a;
    }*/
    public int leerInt() throws IOException{
        return archivo.readInt();
    }
    
   

    public void escribirCadena(String cadena) {
        try {
            StringBuilder c = new StringBuilder(cadena);
            c.setLength(50);
            archivo.writeBytes(c.toString());
        } catch (IOException ex) {

        }
    }

    public void escribirInt(int numero) {
        try {
            archivo.writeInt(numero);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivoDirecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public long tamArchivo(){
        long tam=0;
        if (archivo!=null) {
            
        
        try {
            
             tam= archivo.length();
            
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivoDirecto.class.getName()).log(Level.SEVERE, null, ex);
        }}
        return tam;
    }

    /* public void escribirCadena(String cadena){
        
     try {
     StringBuffer bufer = null;
     if (cadena != null) {
     bufer = new StringBuffer(cadena);
     } else {
     bufer = new StringBuffer(50);
     }
     bufer.setLength(50);//tamaño al bufer

     archivo.writeChars(bufer.toString());
     } catch (IOException ex) {
     Logger.getLogger(ManejoArchivoDirecto.class.getName()).log(Level.SEVERE, null, ex);
     }*/
    /*    public Pelicula obtenerP(int numRegistro){
     Pelicula p= new Pelicula();
     if (numRegistro < 1) {
     System.out.println("Fuera de rango");
     }
     archivo.seek((numRegistro)*Pelicula.tamanio);
    
     p.setNombre(leerCadena(50));
     p.setGenero(leerCadena(50));    
     }*/

    /*  public String leerCadena(int tam) throws IOException {
     byte buffer[] = new byte[tam];
     archivo.read(buffer);

     return new String(buffer);
     }*/
}
