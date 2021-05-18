package console;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AutoAnfibio autoAnf = new AutoAnfibio();
        autoAnf.encenderDesdeInterface();
        autoAnf.detenerMotor();
        autoAnf.arrancarBote();
        autoAnf.detenerBote();
        
        // TODO code application logic here
    }
    
}
