package datos;

import dominio.Pelicula;
import excepciones.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franco
 */
public class AccesoDatosArchivo implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
//        Path rutaArc = Paths.get(RUTADIR + nombreRecurso);
//        return Files.exists(rutaArc);
        File archivo = new File(RUTADIR + nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {

        var archivo = new File(RUTADIR + nombreRecurso);
        List<Pelicula> listaPelicula = new ArrayList<>();

        try ( var entrada = new BufferedReader(new FileReader(archivo))) {

            String linea = entrada.readLine();

            while (linea != null) {
                var pelicula = new Pelicula(linea);
                listaPelicula.add(pelicula);
                linea = entrada.readLine();

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar: " + ex.getMessage());
        }
        return listaPelicula;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {

        //File archivo = new File(RUTADIR + nombreRecurso);
        var archivo = new File(RUTADIR + nombreRecurso);

        try ( var salida = new PrintWriter(new FileWriter(archivo, anexar))) {
            salida.println(pelicula.getNombre());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(RUTADIR + nombreRecurso);
        String resultado = "No encontrada";

        try ( var entrada = new BufferedReader(new FileReader(archivo))) {

            String linea = entrada.readLine();

            while (linea != null) {
                if (linea.equals(buscar)) {
                    resultado = "Le peli " + linea + " fue encontrada";
                    break;
                }
                linea = entrada.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al escribir: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al escribir: " + ex.getMessage());
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
        try ( var serializar = new ObjectOutputStream(new FileOutputStream("objetoSerializado.dat"))) {

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
        try (var deserializar = new ObjectInputStream(new FileInputStream("objetoSerializado.dat"))) {
            return (Pelicula) deserializar.readObject();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al serializar el archivo: " + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al serializar el archivo: " + ex.getMessage());
        }

    }

}
