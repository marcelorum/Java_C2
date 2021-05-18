package principal;

/**
 * Manejo de excepciones no comprobadas.
 * 
 * @author Franco
 * @since 5 mayo 2021
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nroEnteros = new int[10];
        
        //Bloque try-catch para manejar la excepcion
        try {
            System.out.println("Cargamos el arreglo...");
            nroEnteros[0] = 23;
            nroEnteros[1] = 54;
            nroEnteros[2] = 87;
            //nroEnteros[15] = 108/0; //Capturamos esta excepcion
            System.out.println("Finaliza carga de arreglo..."); //Si ocurre la excepcion, esta linea no se ejecuta.
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException ex) {
            //Capturamos un ArrayIndexOutOfBoundsException o ArithmeticException
            //que son subclases de RuntimeException.
            System.err.println("Error en la carga del arreglo. " + ex.getMessage());
            ex.printStackTrace();
        } catch(RuntimeException ex){
            //Siempre se captura lo mas general al ultimo.
            System.err.println("Error runtime. " + ex.getMessage());
            ex.printStackTrace();
        } finally{
            //Siempre se va a ejecutar este bloque
            System.out.println("Estoy en el bloque finally.");
        }
        
        //Si se captura la excepcion, se ejecuta el siguiente bloque
        System.out.println("==Recorro arreglo==");
        for (int unNumero : nroEnteros) {
            System.out.println(unNumero);
        }
        
    }// fin del main

}
