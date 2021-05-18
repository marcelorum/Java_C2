package comparators;

import dominio.Pelicula;
import java.util.Comparator;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class CompararFechaLanzamiento implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula peli1, Pelicula peli2) {
        return peli1.getFechaLanzamiento().compareTo(peli2.getFechaLanzamiento());
    }

}
