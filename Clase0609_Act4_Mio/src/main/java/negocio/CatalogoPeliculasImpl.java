package negocio;

import datos.*;
import dominio.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Paquete negocio - Clase CatalogoPeliculasImpl. En esta clase se implementa la
 * lógica de negocio del software. Es intermediaria de la capa consola y datos.
 *
 * @author Angonoa, Franco
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    //CAMPO
    private final IAccesoDatos datos;

    //CONSTRUCTOR
    public CatalogoPeliculasImpl() {
        datos = new AccesoDatosBD();
    }

    //METODO
    @Override
    public int agregarPelicula(String nombrePelicula, LocalDate fecha, String genero) {
        //Creamos el objeto de tipo Pelicula
        Pelicula nuevaPelicula = new Pelicula(nombrePelicula, fecha, genero);
        int filasAfectadas = 0;

        try {
            filasAfectadas = datos.guardar(nuevaPelicula);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return filasAfectadas;
    }

    @Override
    public String listarPeliculas() {
        String listado = "__LISTADO__\n[\n";
        
        try {
            List<Pelicula> peliculas  = datos.listar();         

            for (Pelicula pelicula : peliculas) {
                if (pelicula != null) {
                    listado += pelicula + "\n";
                }
            }           

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        listado += "]";

        return listado;
    }

    @Override
    public int modificarPelicula(int idPelicula, String nombrePelicula, LocalDate fecha, String genero) {
        Pelicula peliculaModificar = new Pelicula(idPelicula, nombrePelicula, fecha, genero);
        int filasAfectadas = 0;

        try {
            filasAfectadas = datos.modificar(peliculaModificar);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return filasAfectadas;
    }

    @Override
    public int borrarPelicula(int idPelicula) {
        Pelicula peliculaBorrar = new Pelicula(idPelicula);
        
        int filasAfectadas = 0;
        
        try {
            filasAfectadas = datos.borrar(peliculaBorrar);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return filasAfectadas;
    }

    @Override
    public String buscarPelicula(int idPelicula) {
        //Completar
        return null;
    }

}
