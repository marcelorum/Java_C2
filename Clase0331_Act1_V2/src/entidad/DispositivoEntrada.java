package entidad;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public abstract class DispositivoEntrada {
    
    //CAMPOS
    protected String tipoEntrada;
    protected String marca;
    
    //CONSTRUCTOR
    public DispositivoEntrada(String tipoEntrada, String marca){
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
        return "DispositivoEntrada{" + "tipoEntrada=" + tipoEntrada + ", marca=" + marca + '}';
    }
    
    public abstract String devolverMarcaRegistrada();
    
}
