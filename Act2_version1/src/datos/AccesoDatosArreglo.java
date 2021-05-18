package datos;

import dominio.Pelicula;

/**
 * Paquete datos - Clase AccesoDatosArreglo. Es una clase de implementación que
 * contiene los métodos implementados para la manipulación y acceso al arreglo.
 *
 * @author Angonoa, Franco
 */
public class AccesoDatosArreglo implements IAccesoDatos {

    //CAMPO
    private final Pelicula[] peliculas;

    //CONSTRUCTOR
    public AccesoDatosArreglo() {
        peliculas = new Pelicula[MAX_PELICULAS];
    }

    //METODOS 
    @Override
    public Pelicula[] listar() {
        return peliculas;
    }

    @Override
    public void guardar(Pelicula pelicula) {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = pelicula;
                break;
            }
        }
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null && pelicula.getNombre().equals(nombrePelicula)) {
                return pelicula;
            }
        }
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (peliculas[i].getNombre().equals(nombrePelicula)) {
                    peliculas[i] = null;
                    break;
                }
            }
        }
    }

}
