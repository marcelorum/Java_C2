package datos;

import dominio.Pelicula;

/**
 * Paquete datos - Interfaz IAccesoDatos. Interfaz que contiene los metodos o
 * constantes para todas las clases de implementacion que requieran acceso a los
 * datos.
 *
 * @author Angonoa, Franco
 */
public interface IAccesoDatos {

    //CAMPOS CONSTANTES
    int MAX_PELICULAS = 10;

    //METODOS ABSTRACTOS
    Pelicula[] listar();

    void guardar(Pelicula pelicula);

    Pelicula buscar(String nombrePelicula);

    void borrar(String nombrePelicula);

}
