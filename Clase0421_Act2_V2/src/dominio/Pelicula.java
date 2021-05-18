package dominio;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Paquete dominio - Clase Pelicula. Representa las películas que se quieren
 * almacenar en un catálogo.
 *
 * @author Angonoa, Franco
 */
public class Pelicula implements Comparable<Pelicula>{

    //CAMPOS
    private String nombre;
    private LocalDate fechaLanzamiento;
    private Genero genero;
    private EstadoAlquiler estadoAlquiler;

    //CONSTRUCTORES
    public Pelicula() {

    }

    public Pelicula(String nombre, LocalDate fechaLanzamiento, Genero genero, EstadoAlquiler estadoAlquiler) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
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

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
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
        return "{Nombre pelicula: " + nombre + ", Fecha de lanzamiento: " + fechaLanzamiento + ", Genero: " + genero + ", Estado de alquiler: " + estadoAlquiler + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.fechaLanzamiento, other.fechaLanzamiento)) {
            return false;
        }
        if (this.genero != other.genero) {
            return false;
        }
        if (this.estadoAlquiler != other.estadoAlquiler) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Pelicula otraPelicula) {
        return this.nombre.compareTo(otraPelicula.getNombre());
    }
    
    

}
