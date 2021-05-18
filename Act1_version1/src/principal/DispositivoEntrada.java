package principal;

/**
 * Clase DispositivoEntrada. Es la superclase de la jerarquia con Raton y
 * Teclado.
 *
 * @author Angonoa, Franco
 */
public abstract class DispositivoEntrada {

    //CAMPOS
    private String tipoEntrada;
    private String marca;

    //CONTRUCTOR
    public DispositivoEntrada(String tipoEntrada, String marca) {
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    //METODOS
    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Tipo de entrada: " + tipoEntrada + ", marca: " + marca + "]";
    }

}
