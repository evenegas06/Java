package tarea3archivosdirectos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Principal;

public class Controlador {

    ManejoArchivoDirecto objetoArchivos;
    private ArrayList<Pelicula> listaPeliculas = null;

    public ManejoArchivoDirecto getObjetoArchivos() {
        return objetoArchivos;
    }

    public void setObjetoArchivos(ManejoArchivoDirecto objetoArchivos) {
        this.objetoArchivos = objetoArchivos;
    }
    
    private ArrayList<Pelicula> arrayAux = null;
    private int id=0;

    public Controlador() {
        objetoArchivos = new ManejoArchivoDirecto();
        objetoArchivos.abrirArchivo("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
        setListaPeliculas(leerArchivo());
       
        
       
            long reg=0;
            int as = 0;
            
            objetoArchivos.abrirArchivo("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
                 reg=objetoArchivos.tamArchivo();
                 if (reg!=0) {
                
            
            try {
                
                objetoArchivos.getArchivo().seek(reg-208);
                as=objetoArchivos.leerInt();
            } catch (IOException ex) {
               
            }
                 }else{
                 as=0;
                 }
                 setId(as);
        
        //objetoArchivos.cerrarArchivo();
    
    }

    public void darDeAlta(Pelicula p) {
        if (listaPeliculas == null) {
            listaPeliculas = new ArrayList<>();
        }
      
       
        listaPeliculas.add(p);//Agrega la pelicula al arrayList
    }

    public void imprimirListaEnTerminal() {
        for (Pelicula p : listaPeliculas) {
            System.out.println("Nombre: "
                    + p.getNombre()
                    + " Director: " + p.getDirector());
            //listaPeliculas=arrayAux;
        }
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public void setArrayAux(ArrayList<Pelicula> arrayAux) {
        this.arrayAux = arrayAux;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public ArrayList<Pelicula> getArrayAux() {
        return arrayAux;
    }

    public void agregarAux(Pelicula p) {
        if (arrayAux == null) {
            arrayAux = new ArrayList<>();
        }
        arrayAux.add(p);
    }

    public void borrarDeArreglo(Pelicula p) {
        
        listaPeliculas.remove(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /***********************/
    
    public ArrayList<Pelicula> leerArchivo() {
        
       
        ArrayList<Pelicula> temp = new ArrayList<>();

        try {
            if (objetoArchivos.getArchivo().length() > 0) {

                try {
                    for (int i = 0; i < objetoArchivos.getArchivo().length() ; i += 208) {

                        Pelicula p = new Pelicula();
                        p.setID(objetoArchivos.leerInt());
                        p.setNombre(objetoArchivos.leerCadena(50));
                        p.setDirector(objetoArchivos.leerCadena(50));
                        p.setDuracion(objetoArchivos.leerInt());
                        p.setGenero(objetoArchivos.leerCadena(50));
                        p.setClasificacion(objetoArchivos.leerCadena(50));

                        temp.add(p);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                objetoArchivos.getArchivo().close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

   
    
}
