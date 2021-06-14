package datos;

import dominio.Campeonato;
import java.time.LocalDate;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public interface IAccesoDatos {
    
    void registrar(Campeonato camp);    // 1 registrar
    
    void modFecha(String nomCamp, LocalDate fechaIni);    // 2 modificar
    
    void modEq(String nomCamp, int cantidadEquipos);    // 2 modificar
    
    Campeonato buscar(String nomCamp);  // 3 Buscar
    
    void borrar(String nomCamp);        // 4 eliminar
    
    Campeonato[] listar();      // 5 Listar
    
    String getNombres();
    
    int checkDate(LocalDate fechaNew);
    
}
