package main;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class MiExcepcion {
    public void devolverExcNoComprobada() throws RuntimeException{
        //La sentencia throw
        throw new RuntimeException("Excepción no comprobada");
    }
    
    // capturar
    public void devolverExcComprobada(){
        try{
            throw new IOException("Excepcion comprobada");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    //devolver
    public void devolverExcepcionComprobada() throws SQLException{
        throw new SQLException("Excepción Comprobadisima");
    }
    
}
