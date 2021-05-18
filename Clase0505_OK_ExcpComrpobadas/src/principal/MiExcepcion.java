package principal;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Franco
 * @since 5 de mayo 2021
 */
public class MiExcepcion {

    /**
     * Devuelve una excp no comprobada.
     *
     * @throws RuntimeException que es subclase de Exception, pero es una
     * excepcion y es no comprobada.
     */
    public void devolverExcNoComprobada() throws RuntimeException {

        //La sentencia throw        
        throw new RuntimeException("Soy una excepcion no comprobada");
    }

    /**
     * Se captura una excepcion comprobada. Es decir que el lenguaje nos obliga
     * a que la manejemos o declararla. Aqui se elije manejarlas.
     */
    public void capturarExcComprobada() {

        //Capturamos la excepcion con try-catch
        try {
            //La sentencia throw
            throw new IOException("Soy una excepcion comprobada");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Devuelve una excepcion comprobada. Es decir que el lenguaje nos obliga a
     * que la manejemos o declararla. Aqui se elije declararlas.
     *
     * @throws SQLException que es subclase de Exception (comprobadas)
     */
    public void devolverExcComprobada() throws SQLException {
        throw new SQLException("Soy otra excepcion comprobada");
    }

}
