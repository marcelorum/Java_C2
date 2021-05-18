package dominio;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Paquete dominio - Clase Pelicula. Representa las películas que se quieren
 * almacenar en un catálogo.
 *
 * @author Angonoa, Franco
 */
public class Pelicula implements Comparable<Pelicula> {

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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.fechaLanzamiento);
        hash = 29 * hash + Objects.hashCode(this.genero);
        hash = 29 * hash + Objects.hashCode(this.estadoAlquiler);
        return hash;
    }

    /**
     * Sobreescribimos el metodo para que los Set (HashSet, TreeSet) sepan que
     * campos tener en cuenta para determinar si el objeto esta duplicado o no.
     * Ya que los Set guardan elementos unicos.
     *
     * @param obj objeto para comparar con el actual.
     * @return true si los objetos son iguales
     */
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

    /**
     * Debe ser implementado para el TreeSet, asi tiene informacion sobre el
     * ordenamiento. Tambien lo puede implementar un ArrayList mediante el uso
     * de Collections.
     *
     * @param otraPelicula objeto de tipo Pelicula que se compara con un objeto
     * actual
     * @return negativo, cero o positivo que define el ordenamiento.
     */
    @Override
    public int compareTo(Pelicula otraPelicula) {
        //forma ascendente: return this.estadoAlquiler.compareTo(otraPelicula.getEstadoAlquiler());

        //forma descendente:
        if (this.nombre.compareTo(otraPelicula.getNombre()) > 1) {
            return -1;
        } else {
            return 1;
        }
    }

}
