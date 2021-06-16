package comparator;

import dominio.Campeonato;
import java.util.Comparator;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class ComparaFechas implements Comparator<Campeonato> {

    @Override
    public int compare(Campeonato camp1, Campeonato camp2) {
        return camp1.getFechaIni().compareTo(camp2.getFechaIni());
    }
}
