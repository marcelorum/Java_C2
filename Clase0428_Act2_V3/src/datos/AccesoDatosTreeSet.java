package datos;

import dominio.Pelicula;
import java.util.*;

/**
 * Paquete datos - Clase AccesoDatosTreeSet. Es una clase de implementacion que
 * contiene los metodos implementados para la manipulación y acceso a un TreeSet
 * de la interfaz Set.
 *
 * @author Franco
 */
public class AccesoDatosTreeSet implements IAccesoDatos {

    //CAMPO
    private final Set<Pelicula> treePeliculas;

    //CONSTRUCTOR
    public AccesoDatosTreeSet() {
        treePeliculas = new TreeSet<>();
    }

    @Override
    public Pelicula[] listar() {
        return treePeliculas.toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        treePeliculas.add(pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        for (Pelicula miPelicula : treePeliculas) {
            if (miPelicula.getNombre().equals(nombrePelicula)) {
                return miPelicula;
            }
        }
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {
        treePeliculas.remove(buscar(nombrePelicula));
    }

    @Override
    public String getNombresPeliculas() {
        return null;
    }

}
