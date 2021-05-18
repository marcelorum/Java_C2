package console;

import java.io.Serializable;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AutoAnfibio extends AutoBasico implements IBoteMotorizado, Serializable{

    @Override
    public void arrancarBote() {
        System.out.println("Arrancando Bote");
    }

    @Override
    public void detenerBote() {
        System.out.println("Deteniendo Bote");
    }
    
    
}