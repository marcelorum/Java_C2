package principal;

import java.sql.SQLException;

/**
 * Manejo y devolucion de excepciones comprobadas y no comprobadas.
 * 
 * @author Franco
 * @since 5 de mayo 2021
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MiExcepcion ex = new MiExcepcion();
        try {
            //No me obliga capturarlas.
            ex.devolverExcNoComprobada();
        } catch (RuntimeException re) {
            re.printStackTrace();
        }

        ex.capturarExcComprobada(); //El metodo ya captura la excepcion.
                
        try {
            //Nos obliga capturarlas, porque el metodo devuelve una excepcion
            ex.devolverExcComprobada();
        } catch (SQLException ex1) {
            System.out.println("Capturamos desde el main");
            ex1.printStackTrace();
        }
        
    }

}
