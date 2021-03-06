package negocio;

import datos.AccesoDatosImp;
import datos.IAccesoDatos;
import dominio.Campeonato;
import dominio.SistemaCampeonato;
import dominio.TipoCampeonato;
import java.time.LocalDate;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class GestorCampeonatoImp implements IGestorCampeonato {
    
    // CAMPO
    private final IAccesoDatos datos;
    
    // CONSTRUCTOR

    public GestorCampeonatoImp() {
        datos = new AccesoDatosImp();
    }
    
    // METODOS
    
    @Override
    public void regCamp(String nombre, LocalDate fechaIni, LocalDate fechaFin, SistemaCampeonato sistemaCampeonato, TipoCampeonato tipoCampeonato, int cantidadEquipos) {
        Campeonato nuevoCamp = new Campeonato(nombre, fechaIni, fechaFin, sistemaCampeonato, tipoCampeonato,cantidadEquipos);
        datos.registrar(nuevoCamp);
    }

    @Override
    public String listCamp() {
        Campeonato[] camp = datos.listar();
        String lista = "";
        for (Campeonato x : camp) {
            lista += x + "\n";
        }
        return lista;
    }

    @Override
    public String consuCamp(String nombreCamp) {
        String info = "";
        Campeonato camp = datos.buscar(nombreCamp);
        if(camp != null) {
            info += "\n Información del Campeonato"
                    + "\n-----------------------------"
                    + "\nNombre: " + camp.getNombre()
                    + "\nFecha Inicio: " + camp.getFechaIni() + " || Fecha Fin: " + camp.getFechaFin()
                    + "\nDuración: " + camp.calcularDuracionCamp() + " días"
                    + "\nFecha límite de inscripción: " + camp.limiteInscripcion()
                    + "\nTipo: " + camp.getTipoCampeonato() + " - Sistema: " + camp.getSistemaCampeonato()
                    + "\nCaracterística: " + camp.getSistemaCampeonato().getCaracteristica()
                    + "\nCantidad de Equipos: " + camp.getCantidadEquipos()
                    + "\nCantidad de Fechas: " + camp.cuantasFechas()
                    + "\nCantidad de Partidos: " + camp.cuantosPartidosPorFecha()
                    + "\n-----------------------------";
        }else{
            info = "\nERROR: Campeonato no existe\n";
        }
        return info;
    }

    @Override
    public void delCamp(String nombreCamp) {
        if(datos.buscar(nombreCamp) != null){
            datos.borrar(nombreCamp);
        }else{
            System.out.println("\nERROR: Campeonato no existe\n");
        }
        
    }

    @Override
    public void modEq(String nombre, int cantidadEquipos) {
        if(datos.buscar(nombre) != null){
            Campeonato camp = datos.buscar(nombre);
            int eqOld = camp.getCantidadEquipos();
            datos.modEq(nombre, cantidadEquipos);
            int eqNew = camp.getCantidadEquipos();
            System.out.println("Los equipos fueron cambiados de " + eqOld + " a " + eqNew);
        }else{
            System.out.println("\nERROR: Campeonato no existe\n");
        }
    }

    @Override
    public void modFecha(String nombre, LocalDate fechaFin) {
        if(datos.buscar(nombre) != null){
            Campeonato camp = datos.buscar(nombre);
            LocalDate fechaOld = camp.getFechaIni();
            datos.modFecha(nombre, fechaFin);
            LocalDate fechaNew = camp.getFechaIni();
            System.out.println("La fecha fue cambiada de " + fechaOld + " a " + fechaNew);
        }else{
            System.out.println("\nERROR: Campeonato no existe\n");
        }
    }
    
    private String tokenizer(String nomCamps){
        StringTokenizer token = new StringTokenizer(nomCamps, ",");
        String unToken ="";
        while(token.hasMoreTokens()){
            unToken += token.nextToken() + "\n";
        }
        return unToken;
    }
            
    @Override
    public String filtrarCamp(String patron) {
        String nomCamps = datos.getNombres();
        String filtrado = "\nFiltrados:"
                + "\n";
        Pattern pat = Pattern.compile(".*" +patron+ ".*");
        Matcher mat = pat.matcher(tokenizer(nomCamps));
        while(mat.find()){
            filtrado += mat.group() + "\n";
        }
        return filtrado;
    }

    @Override
    public int checkDate(LocalDate fechaNew) {
        int control = datos.checkDate(fechaNew);
        return control;
    }
    
}
