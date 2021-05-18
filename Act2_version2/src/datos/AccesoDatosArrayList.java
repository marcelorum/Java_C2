package datos;

import comparators.*;
import dominio.Pelicula;
import java.util.*;

/**
 * Paquete datos - Clase AccesoDatosArrayList. Es una clase de implementacion
 * que contiene los metodos implementados para la manipulación y acceso a un
 * ArrayList de la interfaz List.
 *
 * @author Franco
 */
public class AccesoDatosArrayList implements IAccesoDatos {

    //CAMPO
    private final List<Pelicula> arregloPeliculas;

    //CONSTRUCTOR
    public AccesoDatosArrayList() {
        arregloPeliculas = new ArrayList<>();
    }

    @Override
    public Pelicula[] listar() {
        //Collections es para la interfaz Comparable:
        //Collections.sort(arregloPeliculas);

        //Los siguientes son con la interfaz Comparator:
        //arregloPeliculas.sort(new CompararNombre());
        arregloPeliculas.sort(new CompararFechaLanzamiento());
        return arregloPeliculas.toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        arregloPeliculas.add(pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        return buscarUnaPelicula(nombrePelicula);
    }

    @Override
    public void borrar(String nombrePelicula) {
        Pelicula peliBorrar = buscarUnaPelicula(nombrePelicula);
        arregloPeliculas.remove(peliBorrar);
    }

    private Pelicula buscarUnaPelicula(String nombrePelicula) {
        for (Pelicula miPelicula : arregloPeliculas) {
            if (miPelicula.getNombre().equals(nombrePelicula)) {
                return miPelicula;
            }
        }

        return null;
    }

}
