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
        String lista = "[";
        for (Campeonato x : camp) {
            lista += x + "\n";
        }
        lista += "]";
        return lista;
    }

    @Override
    public String consuCamp(String nombreCamp) {
        String info = "INFO: ";
        Campeonato camp = datos.buscar(nombreCamp);
        SistemaCampeonato sis = camp.getSistemaCampeonato();
        if(camp != null){
            info += "\nNombre: " + camp.getNombre();
            info += "\nFecha Inicio: " + camp.getFechaIni() + " - Fecha Fin: " + camp.getFechaFin();
            info += "\nDuración: " + camp.calcularDuracionCamp() + " días";
            info += "\nFecha límite: " + camp.limiteInscripcion();
            info += "\nTipo: " + camp.getTipoCampeonato() + " - Sistema: " + sis;
            info += "\nCaract: " + sis.getCaracteristica();
            info += "\nCantidad Equipos: " + camp.getCantidadEquipos();
            info += "\nCantidad de Fechas: " + camp.cuantasFechas();
            info += "\nCant Partidos: " + camp.cuantosPartidosPorFecha();
            info += "\nINFO";
        }
        return info;
    }

    @Override
    public void delCamp(String nombreCamp) {
        datos.borrar(nombreCamp);
    }

    @Override
    public void modEq(String nombre, int cantidadEquipos) {
        datos.modEq(nombre, cantidadEquipos);
    }

    @Override
    public void modFecha(String nombre, LocalDate fechaFin) {
        datos.modFecha(nombre, fechaFin);
    }
    
    private String tokenizer(String nomCamps){
        StringTokenizer token = new StringTokenizer(nomCamps, ",");
        String unToken ="";
        while(token.hasMoreTokens()){
            unToken += token.nextToken() + "\n";
        }
        System.out.println("TOKEN: " + unToken);
        return unToken;
    }
            

    @Override
    public String filtrarCamp(String patron) {
        String nomCamps = datos.getNombres();
        String filtrado = "";

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
