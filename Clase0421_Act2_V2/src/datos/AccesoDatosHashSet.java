package datos;

import dominio.Pelicula;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AccesoDatosHashSet implements IAccesoDatos {
    
    // CAMPO
    private final Set<Pelicula> hashPeliculas;
    
    // CONSTRUCTOR
    public AccesoDatosHashSet(){
        hashPeliculas = new HashSet<>();
    }

    @Override
    public Pelicula[] listar() {
        return hashPeliculas.toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        hashPeliculas.add(pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        for (Pelicula miPelicula : hashPeliculas) {
            if(miPelicula.getNombre().equals(nombrePelicula)){
                return miPelicula;
            }
            
        }
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {
        hashPeliculas.remove(buscar(nombrePelicula));
    }
    
}
