package principal;

import java.io.Serializable;

/**
 * Clase AutoAnfibio. Representa a todos los autos aunfibio, que son los que
 * operan tanto en tierra como en agua. Hereda los atributos y comportamientos
 * de un auto basico e implementa comportamientos de un bote con motor. Como
 * extra, se implementa la interfaz Serializable, esto permite que se puedan
 * guardar los objetos de esta clase, pero ese desarrollo no está contemplado en
 * este proyecto.
 *
 * @author Angonoa Franco
 */
public class AutoAnfibio
        extends AutoBasico
        implements IBoteMotorizado, Serializable {

    /**
     * Metodo heredado de AutoBasico pero sobreescrito en esta subclase.
     */
    @Override
    public void encenderDesdeInterfaz() {
        System.out.println("Estoy encendiendo desde AutoAnfibio (Subclase)");
    }

    /**
     * Metodo abstracto de la interfaz IBote, que lo hereda BoteMotorizado y que
     * debe ser implementado aqui.
     */
    @Override
    public void arrancarBote() {
        System.out.println("Arrancando el motor del bote");
    }

    /**
     * Metodo abstracto de la interfaz IBote, que lo hereda BoteMotorizado y que
     * debe ser implementado aqui.
     */
    @Override
    public void detenerBote() {
        System.out.println("Deteniendo el motor del bote");
    }

    /**
     * Metodo abstracto de la interfaz IBoteMotorizado que debe ser implementado
     * aqui.
     */
    @Override
    public void repararMotor() {

    }

}
