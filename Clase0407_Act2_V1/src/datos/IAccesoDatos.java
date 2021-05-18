package datos;

import dominio.Pelicula;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public interface IAccesoDatos {
    
    // CAMPOS CONSTANTES

    int MAX_PELICULAS = 10;
    
    // METODOS ABTRACTOS

    Pelicula[] listar();

    void guardar(Pelicula pelicula);

    Pelicula buscar(String nombrePelicula);

    void borrar(String nombrePelicula);

}
