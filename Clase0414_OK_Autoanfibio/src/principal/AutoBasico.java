package principal;

/**
 * Clase AutoBasico. Representa a todos autos que tienen las funcionalidades
 * basicas. Implementa de la interface Auto.
 *
 * @author Angonoa Franco
 */
public class AutoBasico implements IAuto {

    /**
     * Metodo abstracto de la interfaz ue debe ser implementado aqui.
     */
    @Override
    public void encenderDesdeInterfaz() {
        System.out.println("Estoy encendiendo");
    }

    /**
     * Metodo abstracto de la interfaz ue debe ser implementado aqui.
     */
    @Override
    public void detenerDesdeInterfaz() {
        System.out.println("Estoy deteniendo");
    }

}
