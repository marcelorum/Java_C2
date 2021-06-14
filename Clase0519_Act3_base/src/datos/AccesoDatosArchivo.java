package datos;

import dominio.Pelicula;
import excepciones.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author Franco
 */
public class AccesoDatosArchivo implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {
        return false;
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso){
        return null;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar){
        
    }

    @Override
    public String buscar(String nombreRecurso, String buscar){
        return null;
    }

    @Override
    public void crear(String nombreRecurso){
        

    }

    @Override
    public void borrar(String nombreRecurso){
        
    }
    
    @Override
    public void serializar(Pelicula unaPelicula) {
        
    }
    
    @Override
    public Pelicula deserializar() {
        return null;
    }

}
