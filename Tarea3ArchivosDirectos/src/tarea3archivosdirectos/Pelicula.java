package tarea3archivosdirectos;

public class Pelicula {
    public static final int tamanio = 208;
    private  int id;
    private String nombre;//50
    private String genero;//50
    private int duracion;//50
    private String clasificacion;//50
    private String director;//50

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" + this.nombre + " ." + this.genero + this.clasificacion + this.director + this.duracion;
    }

}
