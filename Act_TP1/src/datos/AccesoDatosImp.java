package datos;

import comparator.ComparaFechas;
import dominio.Campeonato;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce marcelorum@gmail.com
 *
 */
public class AccesoDatosImp implements IAccesoDatos {

    // CAMPOS
    private final List<Campeonato> arrayCamp;

    // CONSTRUCTOR
    public AccesoDatosImp() {
        arrayCamp = new ArrayList<>();
    }

    // METODOS
    @Override
    public void registrar(Campeonato camp) {
        arrayCamp.add(camp);
    }

    @Override
    public Campeonato[] listar() {
        arrayCamp.sort(new ComparaFechas());
        return arrayCamp.toArray(new Campeonato[0]);
    }

    @Override
    public Campeonato buscar(String nomCamp) {
        for (Campeonato x : arrayCamp) {
            if (x.getNombre().equals(nomCamp)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public void borrar(String nomCamp) {
        arrayCamp.remove(buscar(nomCamp));
    }

    @Override
    public void modFecha(String nomCamp, LocalDate fechaIni) {
        for (Campeonato x : arrayCamp) {
            if (x.getNombre().equals(nomCamp)) {
                arrayCamp.get(arrayCamp.indexOf(x)).setFechaIni(fechaIni);
            }
        }
    }

    @Override
    public void modEq(String nomCamp, int cantidadEquipos) {
        for (Campeonato x : arrayCamp) {
            if (x.getNombre().equals(nomCamp)) {
                arrayCamp.get(arrayCamp.indexOf(x)).setCantidadEquipos(cantidadEquipos);
            }
        }
    }

    @Override
    public String getNombres() {
        String nomCamps = "";
        for (Campeonato x : arrayCamp) {
            nomCamps += x.getNombre() + ", ";

        }
        return nomCamps;
    }

    @Override
    public int checkDate(LocalDate fechaNew) {
        int control = 0;
        for (Campeonato x : arrayCamp) {
            if (fechaNew.compareTo(x.getFechaIni()) > 0 && fechaNew.compareTo(x.getFechaFin()) < 0) {
                System.out.println("ESTO SE VE???");
                control = 1;
            }
        }
        return control;
    }
}
