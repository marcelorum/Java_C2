package entidad;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Raton extends DispositivoEntrada {
    
    //CAMPOS
    private final int ID_RATON;
    private static int contadorRatones;
    
    public Raton(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        Raton.contadorRatones++;
        this.ID_RATON = Raton.contadorRatones;
    }
    
    // METODOS
    public int getID_RATON() {
        return ID_RATON;
    }

    @Override
    public String toString() {
        return "Raton{" + "ID_RATON=" + ID_RATON + ' ' + super.toString();
    }

    @Override
    public String devolverMarcaRegistrada() {
        return "El ratón numero " + ID_RATON + " es de todo compu.";
    }
    
    
    
}
