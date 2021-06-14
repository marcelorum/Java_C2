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

    String NOMBRE_RECURSO = "peliculas.txt";
    
    //METODOS ABSTRACTOS
    String agregarPelicula(String nombrePelicula);
    
    String listarPeliculas();
    
    String buscarPelicula(String buscar);
    
    String iniciarCatalogoPeliculas();
    
    String serializar(String nombrePelicula);
    
    String deserializar();
}
