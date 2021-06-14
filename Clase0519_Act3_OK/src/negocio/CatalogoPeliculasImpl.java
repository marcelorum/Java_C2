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
        String agregar;
        Pelicula nuevaPelicula = new Pelicula(nombrePelicula);
        boolean anexar;

        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(nuevaPelicula, NOMBRE_RECURSO, anexar);
            agregar = "La pelicula ha sido agregada";
        } catch (AccesoDatosEx ex) {
            agregar = "No se pudo agregar la pelicula";
            ex.printStackTrace(System.out);
        }

        return agregar;
    }

    @Override
    public String listarPeliculas() {
        String textoPeliculas = "\n==PELICULAS==\n";

        try {
            List<Pelicula> listaPeliculas = datos.listar(NOMBRE_RECURSO);
            for (Pelicula unaPelicula : listaPeliculas) {
                textoPeliculas += unaPelicula.toString() + "\n";
            }
        } catch (LecturaDatosEx ex) {
            textoPeliculas = "Error al listar";
            ex.printStackTrace(System.out);
        }

        return textoPeliculas;
    }

    @Override
    public String buscarPelicula(String buscar) {
        String resultado;

        try {
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);

        } catch (LecturaDatosEx ex) {
            resultado = "Error al buscar";
            ex.printStackTrace(System.out);
        }

        return resultado;
    }

    @Override
    public String iniciarCatalogoPeliculas() {
        String inicioCatalogo;

        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                //Borre
                this.datos.borrar(NOMBRE_RECURSO);
                //Cree
                this.datos.crear(NOMBRE_RECURSO);
            } else {
                //Solamente cree
                this.datos.crear(NOMBRE_RECURSO);
            }

            inicioCatalogo = "Archivo creado con exito";
        } catch (AccesoDatosEx ex) {
            inicioCatalogo = "Error al iniciar el catalogo de peliculas";
            ex.printStackTrace(System.out);
        }

        return inicioCatalogo;
    }

    @Override
    public String serializar(String nombrePelicula) {
        String serializar;
        Pelicula nuevaPeli = new Pelicula(nombrePelicula);

        try {
            datos.serializar(nuevaPeli);
            serializar = "Objeto serializado";
        } catch (AccesoDatosEx ex) {
            serializar = "Error al serializar";
            ex.printStackTrace(System.out);
        }

        return serializar;
    }

    @Override
    public String deserializar() {
        String deserializar;

        try {
            Pelicula peliDeserializada = datos.deserializar();
            deserializar = peliDeserializada.toString();
        } catch (AccesoDatosEx ex) {
            deserializar = "Error al deserializar";
            ex.printStackTrace(System.out);
        }

        return deserializar;
    }

}
