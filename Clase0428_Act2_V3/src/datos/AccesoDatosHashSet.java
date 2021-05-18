package datos;

import dominio.Pelicula;
import java.util.*;

/**
 * Paquete datos - Clase AccesoDatosHashSet. Es una clase de implementacion que
 * contiene los metodos implementados para la manipulación y acceso a un HashSet
 * de la interfaz Set.
 *
 * @author Franco
 */
public class AccesoDatosHashSet implements IAccesoDatos {

    //CAMPO
    private final Set<Pelicula> hashPeliculas;

    //CONSTRUCTOR
    public AccesoDatosHashSet() {
        hashPeliculas = new HashSet<>();
    }

    @Override
    public Pelicula[] listar() {
        return hashPeliculas.toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        hashPeliculas.add(pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        for (Pelicula miPelicula : hashPeliculas) {
            if (miPelicula.getNombre().equals(nombrePelicula)) {
                return miPelicula;
            }
        }
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {
        hashPeliculas.remove(buscar(nombrePelicula));
    }

    @Override
    public String getNombresPeliculas() {
        return null;
    }

}
