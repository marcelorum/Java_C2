package principal;

/**
 * Clase Raton. Subclase de la jerarquia DispositivoEntrada.
 *
 * @author Angonoa, Franco.
 */
public class Raton extends DispositivoEntrada {

    //CAMPOS
    private final int ID_RATON;
    private static int contadorRatones; //Campo DE LA CLASE. Funcion: contar la cantidad de objetos de tipo Raton.

    //CONSTRUCTOR
    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        Raton.contadorRatones++;
        this.ID_RATON = Raton.contadorRatones;
    }
    
    //METODOS
    public int getID_RATON() {
        return ID_RATON;
    }

    @Override
    public String toString() {
        return "Raton [" + "ID_RATON: " + ID_RATON + " - " + super.toString();
    }

}
