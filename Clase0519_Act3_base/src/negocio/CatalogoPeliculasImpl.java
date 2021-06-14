package negocio;

import datos.*;
import dominio.*;
import excepciones.*;
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
        datos = new AccesoDatosArchivo();
    }

    //METODO
    @Override
    public String agregarPelicula(String nombrePelicula) {
        return null;
    }

    @Override
    public String listarPeliculas() {
        return null;
    }

    @Override
    public String buscarPelicula(String buscar) {
        return null;
    }

    @Override
    public String iniciarCatalogoPeliculas() {
        return null;
    }

    @Override
    public String serializar(String nombrePelicula) {
        return null;
                
    }

    @Override
    public String deserializar() {
        return null;              
    }
    
    

}
