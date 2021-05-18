package dominio;

import java.util.Date;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Pelicula {
    //CAMPOS
    private String nombre;
    private Date dechaLanzamiento;
    private Genero genero;
    private EstadoAlquiler estadoAlquiler;
    
    //CONSTRUCTOR
    public Pelicula(){
        
    }

    public Pelicula(String nombre, Date dechaLanzamiento, Genero genero, EstadoAlquiler estadoAlquiler) {
        this.nombre = nombre;
        this.dechaLanzamiento = dechaLanzamiento;
        this.genero = genero;
        this.estadoAlquiler = estadoAlquiler;
    }
    
    //METODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDechaLanzamiento() {
        return dechaLanzamiento;
    }

    public void setDechaLanzamiento(Date dechaLanzamiento) {
        this.dechaLanzamiento = dechaLanzamiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public EstadoAlquiler getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(EstadoAlquiler estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }

    @Override
    public String toString() {
        return "{Nombre=" + nombre + ", dechaLanzamiento=" + dechaLanzamiento + ", genero=" + genero + ", estadoAlquiler=" + estadoAlquiler + '}';
    }
    
}
