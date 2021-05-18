package datos;

import comparators.CompararNombre;
import dominio.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class AccesoDatosArrayList implements IAccesoDatos {
    
    // CAMPO
    private final List<Pelicula> arregloPeliculas;
    
    // CONSTRUCTOR
    public AccesoDatosArrayList(){
        arregloPeliculas = new ArrayList<>();
    }
    

    @Override
    public Pelicula[] listar() {
        //Collections.sort(arregloPeliculas);
        //return (Pelicula[]) arregloPeliculas.toArray(new Pelicula[0]);
        arregloPeliculas.sort(new CompararNombre());
        return arregloPeliculas.toArray(new Pelicula[0]);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        arregloPeliculas.add(pelicula);
    }

    @Override
    public Pelicula buscar(String nombrePelicula) {
        for (Pelicula miPelicula : arregloPeliculas) {
            //Pelicula miPelicula = (Pelicula) peliculaObject;
            if(miPelicula.getNombre().equals(nombrePelicula))
                return miPelicula;
        }
        return null;
    }

    @Override
    public void borrar(String nombrePelicula) {
        arregloPeliculas.remove(buscar(nombrePelicula));
    }
    
}
