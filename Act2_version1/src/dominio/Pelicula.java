package dominio;

import java.time.LocalDate;

/**
 * Paquete dominio - Clase Pelicula. Representa las películas que se quieren
 * almacenar en un catálogo.
 *
 * @author Angonoa, Franco
 */
public class Pelicula {

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

}
