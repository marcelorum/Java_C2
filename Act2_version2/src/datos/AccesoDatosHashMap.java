package datos;

import dominio.Pelicula;
import java.util.*;

/**
 * Paquete datos - Clase AccesoDatosHashMap. Es una clase de implementacion que
 * contiene los metodos implementados para la manipulación y acceso a un HashMap
 * de la interfaz Map.
 *
 * @author Franco
 */
public class AccesoDatosHashMap implements IAccesoDatos {

    //CAMPO
    private final Map<Integer, Pelicula> hashPeliculas;
    private static int nroPelicula;

    //CONSTRUCTOR
    public AccesoDatosHashMap() {
        hashPeliculas = new HashMap<>();
    }

    @Override
    public Pelicula[] listar() {
        return hashPeliculas.values().toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        hashPeliculas.put(nroPelicula++, pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        return hashPeliculas.get(devolverUnaPelicula(nombrePelicula));
    }

    @Override
    public void borrar(String nombrePelicula) {
        hashPeliculas.remove(devolverUnaPelicula(nombrePelicula));
    }

    private int devolverUnaPelicula(String nombrePelicula) {
        Set<Integer> llaves = hashPeliculas.keySet();

        for (Integer unaLlave : llaves) {
            Pelicula unaPeli = hashPeliculas.get(unaLlave);
            if (unaPeli.getNombre().equals(nombrePelicula)) {
                return unaLlave;
            }
        }

        return -1;
    }

}
