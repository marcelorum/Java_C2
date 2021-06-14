package dominio;

import java.io.Serializable;

/**
 * Paquete dominio - Clase Pelicula. Representa las películas que se quieren
 * almacenar en un catálogo.
 *
 * @author Angonoa, Franco
 */
public class Pelicula implements Serializable{

    //CAMPOS
    private String nombre;

    //CONSTRUCTORES
    public Pelicula() {

    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    //METODOS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{Nombre pelicula: " + nombre + "}";
    }

}
