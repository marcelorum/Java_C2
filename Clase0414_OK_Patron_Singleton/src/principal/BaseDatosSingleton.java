package principal;

import java.util.Objects;

/**
 * La clase Base de datos Singleton define el metodo 'getInstancia' que permite
 * a los clientes acceder a la misma instancia de una conexion de la base de
 * datos a traves del programa.
 *
 * @author Franco
 */
public class BaseDatosSingleton {

    //CAMPOS SIRVE PARA SINGLETON
    private static BaseDatosSingleton instancia; //El campo para almacenar la instancia singleton debe declararse estatico

    //CAMPOS PROPIOS
    private String cadenaConexion;

    /**
     * CONSTRUCTOR PRIVADO. El constructor del singleton siempre debe ser
     * privado para evitar llamadas de construccion directas con el operador
     * 'new'.
     */
    private BaseDatosSingleton(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion; // Algun código de inicialización, como la propia conexion al servidor de una base de datos.
    }

    /**
     * METODO DE CREACION ESTATICO. El metodo estático que controla el acceso a
     * la instancia singleton.
     *
     */
    public static BaseDatosSingleton getInstancia(String cadenaConexion) {
        if (instancia == null) {
            //Garantiza que la instancia aun no se ha inicializadoo.
            instancia = new BaseDatosSingleton(cadenaConexion);
        }

        return instancia;
    }

    //NO ES DEL PATRON. ES PROPIO DE LA CLASE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cadenaConexion);
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
        final BaseDatosSingleton other = (BaseDatosSingleton) obj;
        if (!Objects.equals(this.cadenaConexion, other.cadenaConexion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseDatosSingleton{" + "cadenaConexion=" + cadenaConexion + '}';
    }

}
