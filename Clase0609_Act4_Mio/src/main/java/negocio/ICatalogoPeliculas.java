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
    int agregarPelicula(String nombrePelicula, LocalDate fecha, String genero);

    String listarPeliculas();

    int modificarPelicula(int idPelicula, String nombrePelicula, LocalDate fecha, String genero);

    int borrarPelicula(int idPelicula);
    
    String buscarPelicula(int idPelicula);
}
