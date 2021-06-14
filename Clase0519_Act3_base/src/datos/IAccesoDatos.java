package datos;

import dominio.Pelicula;
import excepciones.*;
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
    boolean existe(String nombreRecurso);

    List<Pelicula> listar(String nombreRecurso);

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar);

    String buscar(String nombreRecurso, String buscar) ;

    void crear(String nombreRecurso) ;

    void borrar(String nombreRecurso);
    
    void serializar(Pelicula unaPelicula);
    
    Pelicula deserializar();
    
    

}
