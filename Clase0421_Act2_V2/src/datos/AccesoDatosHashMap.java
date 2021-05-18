package datos;

import dominio.Pelicula;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AccesoDatosHashMap implements IAccesoDatos {

    // CAMPO
    private final Map<Integer, Pelicula> hashPeliculas;
    private static int nroPelicula;

    // CONST
    public AccesoDatosHashMap() {
        hashPeliculas = new HashMap<>();
    }

    @Override
    public Pelicula[] listar() {
        return hashPeliculas.values().toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        hashPeliculas.put(++nroPelicula, pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        Set<Integer> llaves = hashPeliculas.keySet();
        for (Integer unaLlave : llaves) {
            Pelicula unaPeli = hashPeliculas.get(unaLlave);
            if (unaPeli.getNombre().equals(nombrePelicula)) {
                return unaPeli;
            }

        }
        return null;
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
