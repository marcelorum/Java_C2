package entidad;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Monitor {
    
    //CAMPO
    private final int ID_MONITOR;
    private String marca;
    private double tamanio;
    private static int contadorMonitores;
    
    //CONSTRUCTORES
    private Monitor(){
        this.ID_MONITOR = ++Monitor.contadorMonitores;
    }

    public Monitor(String marca, double tamanio) {
        this();
        this.marca = marca;
        this.tamanio = tamanio;
    }
    
    // METODOS

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public int getID_MONITOR() {
        return ID_MONITOR;
    }

    @Override
    public String toString() {
        return "Monitor{" + "ID_MONITOR=" + ID_MONITOR + ", marca=" + marca + ", tamanio=" + tamanio + '}';
    }
    
}
