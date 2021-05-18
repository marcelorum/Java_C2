package negocio;

import dominio.*;
import java.util.Date;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public interface ICatalogoPeliculas {

    // METODOS ABSTRACTOS
    void agregarPelicula(String nombrePelicula, Date fecha, Genero genero, EstadoAlquiler estado);

    String listarPeliculas();

    String buscarPelicula(String nombrePelicula);

    //void iniciarCatalogo();
    
    void borrarPelicula(String nombre);
}
