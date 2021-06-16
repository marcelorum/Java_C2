package dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Campeonato {

    // CAMPOS
    private String nombre;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private SistemaCampeonato sistemaCampeonato;
    private TipoCampeonato tipoCampeonato;
    private int cantidadEquipos;

    // CONSTRUCRORES
    public Campeonato() {
    }

    public Campeonato(String nombre, LocalDate fechaIni, LocalDate fechaFin, SistemaCampeonato sistemaCampeonato, TipoCampeonato tipoCampeonato, int cantidadEquipos) {
        this.nombre = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.sistemaCampeonato = sistemaCampeonato;
        this.tipoCampeonato = tipoCampeonato;
        this.cantidadEquipos = cantidadEquipos;
    }

    // METODOS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public SistemaCampeonato getSistemaCampeonato() {
        return sistemaCampeonato;
    }

    public void setSistemaCampeonato(SistemaCampeonato sistemaCampeonato) {
        this.sistemaCampeonato = sistemaCampeonato;
    }

    public TipoCampeonato getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(TipoCampeonato tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    @Override
    public String toString() {
        return "{Nombre=" + nombre + ", Fecha Inicio=" + fechaIni + ", Fecha Fin=" + fechaFin + ", Sistema=" + sistemaCampeonato + ", Tipo=" + tipoCampeonato + ", Cantidad Equipos=" + cantidadEquipos + '}';
    }

    public long calcularDuracionCamp() {
        long dif = getFechaIni().until(getFechaFin(), ChronoUnit.DAYS);
        return dif;
    }

    public int cuantasFechas() {
        int fechas = 0;
        int eq = getCantidadEquipos();
        if (sistemaCampeonato.equals(SistemaCampeonato.TODOSCTODOS)) {
            fechas = eq - 1;
        } else {
            while (eq / 2 >= 1) {
                fechas++;
                eq = eq / 2;
            }
        }
        return fechas;
    }

    public int cuantosPartidosPorFecha() {
        int partidos = 0;
        int fechas = cuantasFechas();
        int eq = getCantidadEquipos();
        if (sistemaCampeonato.equals(SistemaCampeonato.TODOSCTODOS)) {
            partidos = fechas * eq / 2;
        } else {
            partidos = eq - 1;
        }
        return partidos;
    }

    public LocalDate limiteInscripcion() {
        LocalDate limit;
        limit = fechaIni.minusDays(30);
        return limit;
    }

}
