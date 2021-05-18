package principal;

/**
 * Clase Principal. Contiene el metodo main para realizar pruebas.
 *
 * @author Angonoa Franco
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Repaso:
        /*
        -> Superclase Persona
        Subclase Estudiante
        Persona est = new Estudiante();
        
        
        -> Interfaz IAccesoDato
        Clase AccesoBDSQL
        IAccesoDato sql = new AccesoBDSQL();
         */
        
        AutoAnfibio autoAnf = new AutoAnfibio();
        autoAnf.encenderDesdeInterfaz();
        autoAnf.detenerDesdeInterfaz();
        autoAnf.arrancarBote();
    }
}
