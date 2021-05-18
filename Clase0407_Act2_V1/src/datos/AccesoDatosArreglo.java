package datos;

import dominio.Pelicula;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AccesoDatosArreglo implements IAccesoDatos {

    // CAMPO
    private final Pelicula[] peliculas;

    // CONSTRUCTOR
    public AccesoDatosArreglo() {
        peliculas = new Pelicula[MAX_PELICULAS];
    }

    // METODOS
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
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {

    }

}
