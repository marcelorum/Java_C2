package main;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MiExcepcion ex = new MiExcepcion();
        
        
//        try {
//            ex.devolverExcNoComprobada();
//        } catch (RuntimeException re) {
//            //re.printStackTrace();
//            re.printStackTrace();
//        }


        //ex.devolverExcComprobada();
        
        
        try {
            ex.devolverExcepcionComprobada();
        } catch (SQLException ex1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        
        
    }

}
