package negocio;

import datos.*;
import dominio.*;
import java.time.LocalDate;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Paquete negocio - Clase CatalogoPeliculasImpl. En esta clase se implementa la
 * lógica de negocio del software. Es intermediaria de la capa consola y datos.
 *
 * @author Angonoa, Franco
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    //CAMPO
    private final IAccesoDatos datos;

    //CONSTRUCTOR
    public CatalogoPeliculasImpl() {
        datos = new AccesoDatosArrayList();
    }

    //METODO
    @Override
    public void agregarPelicula(String nombrePelicula, LocalDate fecha, Genero genero, EstadoAlquiler estado) {
        //Creamos el objeto de tipo Pelicula
        Pelicula nuevaPelicula = new Pelicula(nombrePelicula, fecha, genero, estado);

        datos.guardar(nuevaPelicula);
    }

    @Override
    public String listarPeliculas() {

        Pelicula[] peliculas = datos.listar();
        String listado = "__LISTADO__\n[\n";

        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                listado += pelicula + "\n";
            }
        }

        listado += "]";

        return listado;
    }

    @Override
    public String buscarPelicula(String nombrePelicula) {
        String datosPelicula = "__INFO DE " + nombrePelicula + "__[";
        
        Pelicula pelicula = datos.buscar(nombrePelicula);
        
        if(pelicula != null) datosPelicula += pelicula.toString();
        
        datosPelicula += "]";
        
        return datosPelicula;
    }

    @Override
    public void borrarPelicula(String nombrePelicula) {
        datos.borrar(nombrePelicula);
    }

    @Override
    public String mostrarNombresPeliculas() {        
        //return usarSplit(datos.getNombresPeliculas());
        return usarTokenizer(datos.getNombresPeliculas());
    }
    
    private String usarSplit(String nombresPeliculas){        
        String[] elementos = nombresPeliculas.split(", ");
        
        String usoSplit = "";
        
        for (String unNombre : elementos) {
            usoSplit += unNombre + "\n";
        }
        
        return usoSplit;        
    }
    
    private String usarTokenizer(String nombresPeliculas){
        StringTokenizer st = new StringTokenizer(nombresPeliculas, ",");
        
        String usoToken = "";
        
        while(st.hasMoreTokens()){
            usoToken += st.nextToken() + "\n";
        }
        usoToken = usoToken.trim();
        return usoToken;
    }

    @Override
    public String aplicarFiltro() {
        String nombresPeliculas = datos.getNombresPeliculas();
        String usoFiltros = "";
        
        //Pattern pattern = Pattern.compile("Kombate"); //Expresion regular
        //Pattern pattern = Pattern.compile(".*Komb.*"); //Expresion regular
        //Pattern pattern = Pattern.compile(".*Komb"); //Expresion regular
        //Pattern pattern = Pattern.compile("^\\d.*"); //Expresion regular
        Pattern pattern = Pattern.compile("^.{4}"); //Expresion regular
        Matcher match = pattern.matcher(usarTokenizer(nombresPeliculas)); //Cadena donde aplicamos la regex
        
        while(match.find()){            
            usoFiltros += match.group() + "\n";
        }
        
        return usoFiltros;
    }
    

}
