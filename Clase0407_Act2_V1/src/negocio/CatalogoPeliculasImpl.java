package negocio;

import datos.*;
import dominio.*;
import java.util.Date;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    // CAMPO
    private final IAccesoDatos datos; // Lo declaro con la interface

    // CONSTRUCTOR
    public CatalogoPeliculasImpl() {
        datos = new AccesoDatosArreglo(); // Lo instancio con la clase de implementación
    }

    // METODO
    @Override
    public void agregarPelicula(String nombrePelicula, Date fecha, Genero genero, EstadoAlquiler estado) {
        // Creamos el obketo de tipo Pelicula
        Pelicula nuevaPelicula = new Pelicula(nombrePelicula, fecha, genero, estado);
        datos.guardar(nuevaPelicula);
    }

    @Override
    public String listarPeliculas() {
        Pelicula[] peliculas = datos.listar();
        String listado = "[";
        for (Pelicula pelicula : peliculas) {
            listado += pelicula + "\n";
        }
        listado += "]";
        return listado;
    }

    @Override
    public String buscarPelicula(String nombrePelicula) {
        return null;
    }

    @Override
    public void borrarPelicula(String nombre) {

    }

}
