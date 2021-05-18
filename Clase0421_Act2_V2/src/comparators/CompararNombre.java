package comparators;

import dominio.Pelicula;
import java.util.Comparator;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class CompararNombre implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula peli1, Pelicula peli2) {
        return peli1.getNombre().compareTo(peli2.getNombre());

    }

}
