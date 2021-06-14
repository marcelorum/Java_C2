package dominio;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Paquete dominio - Clase Pelicula. Representa las películas que se quieren
 * almacenar en un catálogo.
 *
 * @author Angonoa, Franco
 */
public class Pelicula{

    //CAMPOS
    private int idPelicula;
    private String nombre;
    private LocalDate fechaLanzamiento;
    private String genero;

    //CONSTRUCTORES
    public Pelicula() {

    }

    public Pelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    
    public Pelicula(String nombre, LocalDate fechaLanzamiento, String genero) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
    }

    public Pelicula(int idPelicula, String nombre, LocalDate fechaLanzamiento, String genero) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    //METODOS
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idPelicula=" + idPelicula + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", genero=" + genero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.idPelicula;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.fechaLanzamiento);
        hash = 13 * hash + Objects.hashCode(this.genero);
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
        if (this.idPelicula != other.idPelicula) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.fechaLanzamiento, other.fechaLanzamiento)) {
            return false;
        }
        return true;
    }
}
