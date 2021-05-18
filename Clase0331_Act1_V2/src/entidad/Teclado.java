package entidad;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Teclado extends DispositivoEntrada{
    
    //CAMPOS
    private final int ID_TECLADO;
    private static int contadorTeclados;
    
    // CONSTRUCTORES

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        Teclado.contadorTeclados++;
        this.ID_TECLADO = Teclado.contadorTeclados;
    }

    public int getID_TECLADO() {
        return ID_TECLADO;
    }

    @Override
    public String toString() {
        return "Teclado{" + "ID_TECLADO=" + ID_TECLADO + ' ' + super.toString();
    }

    @Override
    public String devolverMarcaRegistrada() {
        return "El teclado numero " + ID_TECLADO + " es de todo compu.";
    }
    
}
