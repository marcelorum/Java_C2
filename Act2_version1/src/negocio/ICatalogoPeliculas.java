package negocio;

import dominio.*;
import java.time.LocalDate;

/**
 * Paquete negocio - Interfaz ICatalogoPeliculas. Interfaz que contiene los
 * metodos que deben ser implementados en las clases que formen parte de la capa
 * de negocio.
 *
 * @author Angonoa, Franco
 */
public interface ICatalogoPeliculas {

    //METODOS ABSTRACTOS
    void agregarPelicula(String nombrePelicula, LocalDate fecha, Genero genero, EstadoAlquiler estado);

    String listarPeliculas();

    String buscarPelicula(String nombrePelicula);

    void borrarPelicula(String nombrePelicula);
}
