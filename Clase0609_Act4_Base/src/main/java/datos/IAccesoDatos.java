package datos;

import dominio.Pelicula;
import java.sql.SQLException;
import java.util.List;

/**
 * Paquete datos - Interfaz IAccesoDatos. Interfaz que contiene los metodos o
 * constantes para todas las clases de implementacion que requieran acceso a los
 * datos.
 *
 * @author Angonoa, Franco
 */
public interface IAccesoDatos {

    //METODOS ABSTRACTOS
    
    List<Pelicula> listar()  throws SQLException;

    int guardar(Pelicula pelicula)  throws SQLException;

    int modificar(Pelicula pelicula)  throws SQLException;

    int borrar(Pelicula pelicula)  throws SQLException;
    
    Pelicula buscarPelicula(Pelicula pelicula) throws SQLException;

}
