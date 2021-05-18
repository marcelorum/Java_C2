package datos;

import dominio.Pelicula;
import java.util.*;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AccesoDatosTreeSet implements IAccesoDatos {
    
    // CAMPO
    private final Set<Pelicula> treePeliculas;
    
    // CONSTRUCTOR
    public AccesoDatosTreeSet(){
        treePeliculas = new TreeSet<>();
    }

    @Override
    public Pelicula[] listar() {
        return treePeliculas.toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        treePeliculas.add(pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        for (Pelicula miPelicula : treePeliculas) {
            if(miPelicula.getNombre().equals(nombrePelicula)){
                return miPelicula;
            }
            
        }
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {
        treePeliculas.remove(buscar(nombrePelicula));
    }
    
}
