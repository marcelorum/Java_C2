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
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {    
        File archivo = new File(RUTADIR + nombreRecurso); // .\\carpetaPeliculas\\peliculas.txt
        return archivo.exists();
        
        //Otra forma de implementarlo:
//        Path rutaArc = Paths.get(RUTADIR + nombreRecurso);
//        return Files.exists(rutaArc);    
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {

        var archivo = new File(RUTADIR + nombreRecurso);
        List<Pelicula> listaPeliculas
                = new ArrayList<>();

        try (var entrada
                = new BufferedReader(new FileReader(archivo))) {

            String linea = entrada.readLine();

            while (linea != null) {
                var pelicula = new Pelicula(linea);
                listaPeliculas.add(pelicula);
                linea = entrada.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar las peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar las peliculas: " + ex.getMessage());
        }

        return listaPeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {

        var archivo = new File(RUTADIR + nombreRecurso);

        try (var salida = new PrintWriter(new FileWriter(archivo, anexar))) {
            salida.println(pelicula.getNombre());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir en el archivo: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir en el archivo: " + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(RUTADIR + nombreRecurso);
        String resultado = "Pelicula no fue encontrada";
        
        try (var entrada = new BufferedReader(new FileReader(archivo))) {
            
            String linea = entrada.readLine();
            
            while(linea != null){
                if(linea.equalsIgnoreCase(buscar)){
                    resultado = "La pelicula " + linea + " fue encontrada en el archivo";
                    break;
                }
                linea = entrada.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar la pelicula: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar la pelicula: " + ex.getMessage());
        }
        
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        Path rutaDir = Paths.get(RUTADIR);
        Path rutaArch = Paths.get(RUTADIR + nombreRecurso);

        try {
            Files.createDirectory(rutaDir);
            Files.createFile(rutaArch);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al crear el archivo: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        Path rutaDir = Paths.get(RUTADIR);
        Path rutaArch = Paths.get(RUTADIR + nombreRecurso);

        try {
            Files.delete(rutaArch);
            Files.delete(rutaDir);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al borrar el archivo: " + ex.getMessage());
        }
    }

    @Override
    public void serializar(Pelicula unaPelicula) throws AccesoDatosEx {
        try (var serializar = new ObjectOutputStream(new FileOutputStream("objetoSerializado.dat"))){
            serializar.writeObject(unaPelicula);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al serializar el archivo: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al serializar el archivo: " + ex.getMessage());
        }        
    }

    @Override
    public Pelicula deserializar() throws AccesoDatosEx {
        try (var deserializar = new ObjectInputStream(new FileInputStream("objetoSerializado.dat"))){
            return (Pelicula) deserializar.readObject();
                        
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al deserializar el archivo: " + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al deserializar el archivo: " + ex.getMessage());
        }
    }

}
