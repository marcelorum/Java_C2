package console;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AutoBasico implements IAuto{

    @Override
    public void encenderDesdeInterface() {
        System.out.println("Estoy encendiendo desde interface");
    }

    @Override
    public void detenerMotor() {
        System.out.println("Detener Motor");
    }
    
    
    
}
