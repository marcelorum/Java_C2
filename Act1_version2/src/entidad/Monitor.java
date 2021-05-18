package entidad;

/**
 * Clase Monitor. Representa todos los monitores del programa. No forma parte de
 * ninguna jerarquia.
 *
 * @author Angonoa, Franco.
 */
public class Monitor {

    //CAMPOS
    private final int ID_MONITOR;
    private String marca;
    private double tamanio;
    private static int contadorMonitores; //Campo DE LA CLASE. Funcion: contar la cantidad de objetos de tipo Monitor.

    //CONSTRUCTORES
    private Monitor() {
        this.ID_MONITOR = ++Monitor.contadorMonitores; //Incremento previo.
    }

    public Monitor(String marca, double tamanio) {
        this(); //llama al constructor por defecto
        this.marca = marca;
        this.tamanio = tamanio;
    }

    //METODOS
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
        return "Monitor [" + "ID_MONITOR: " + ID_MONITOR + ", marca: " + marca + ", tamanio: " + tamanio + ']';
    }
    
}
