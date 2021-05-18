package entidad;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Escaner extends DispositivoEntrada{
    
    // CAMPOS
    private final int ID_ESCANER;
    
    // CONSTRUCTOR
    
    public Escaner(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        this.ID_ESCANER = 0;
    }

    public Escaner(int ID_ESCANER, String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.ID_ESCANER = ID_ESCANER;
    }
    
    // METODOS

    public int getID_ESCANER() {
        return ID_ESCANER;
    }

    @Override
    public String toString() {
        return "Escaner [" + "ID_ESCANER=" + ID_ESCANER + " - " + super.toString();
    }
    
    @Override
    public String devolverMarcaRegistrada() {
        return "El escaner numero " + ID_ESCANER + " es de todo compu.";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.ID_ESCANER;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Escaner other = (Escaner) obj;
        return true;
    }
    
}
