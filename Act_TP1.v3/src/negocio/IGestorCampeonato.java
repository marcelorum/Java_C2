package negocio;

import dominio.*;
import java.time.LocalDate;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public interface IGestorCampeonato {
    
    // METODOS ABSTRACTOS
    
    void regCamp(String nombre, LocalDate fechaIni, LocalDate fechaFin, SistemaCampeonato sistemaCampeonato, TipoCampeonato tipoCampeonato, int cantidadEquipos); // 1 Registrar
    
    void modEq(String nombre, int cantidadEquipos); // 2 Modificar
    
    void modFecha(String nombre, LocalDate fechaFin); // 2 Modificar
    
    String consuCamp(String nombreCamp); // 3 Consultar
    
    void delCamp(String nombreCamp); // 4 Eliminar
    
    String listCamp(); // 5 Listar
    
    String filtrarCamp(String patron); // 6 filtrar 
    
    int checkDate(LocalDate fechaNew);
    
}
