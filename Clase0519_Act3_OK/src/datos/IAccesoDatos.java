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
    
    String RUTADIR = ".\\carpetaPeliculas\\";
    
    //METODOS ABSTRACTOS
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;
    
    void serializar(Pelicula unaPelicula) throws AccesoDatosEx;
    
    Pelicula deserializar() throws AccesoDatosEx;
}
