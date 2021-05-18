package principal;

/**
 * Clase Teclado. Subclase de la jerarquia de DispositivoEntrada.
 *
 * @author Angonoa, Franco.
 */
public class Teclado extends DispositivoEntrada {

    //CAMPOS
    private final int ID_TECLADO;
    private static int contadorTeclados; //Campo DE LA CLASE. Funcion: contar la cantidad de objetos de tipo Teclado.

    //CONSTRUCTOR
    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        Teclado.contadorTeclados++;
        this.ID_TECLADO = Teclado.contadorTeclados;
    }

    //METODOS
    public int getID_TECLADO() {
        return ID_TECLADO;
    }

    @Override
    public String toString() {
        return "Teclado [" + "ID_TECLADO: " + ID_TECLADO + " - " + super.toString();
    }

}
