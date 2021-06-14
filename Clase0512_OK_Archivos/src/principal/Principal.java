package principal;

import static principal.ManejoArchivos.*;

/**
 *
 * @author Franco
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombreArchivo = null;
        
        assert (nombreArchivo != null) : "Se espera una variable con una cadena de texto";

        //crearArchivo(nombreArchivo);
        //escribirArchivo(nombreArchivo, "Batman");
        //escribirArchivo(nombreArchivo, "Spiderman");
        //anexarArchivo(nombreArchivo, "Batman");
        //anexarArchivo(nombreArchivo, "La guerra de los mundos");
        leerArchivo(nombreArchivo);
    }
}
