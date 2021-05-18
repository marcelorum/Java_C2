package consola;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ManejoArchivos ma = new ManejoArchivos();
        
        String nombreArchivo = "miArchivo.txt";
        
        assert (nombreArchivo != null) : "Mensaje que salga del error";
        
        //ma.crearArchivo(nombreArchivo);
        
        //ma.escribirArchivo(nombreArchivo, "Probando escritura en archivo");
        
        // ma.anexarArchivo(nombreArchivo, "Otra info");
        
        ma.leerArchivo(nombreArchivo);
    }
    
}
