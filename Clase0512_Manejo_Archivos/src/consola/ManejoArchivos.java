package consola;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class ManejoArchivos {

    // SIN CAMPOS
    // METODOS
    public void crearArchivo(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        //PrintWriter salida = null;

        try ( PrintWriter salida = new PrintWriter(archivo)) {
            //salida = new PrintWriter(archivo);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
//        } finally {
//            if (salida != null) {
//                salida.close();
//            }
        }
    }

    public void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;

        try {
            salida = new PrintWriter(archivo);
            salida.println(contenido);
            System.out.println("Se ha escrito");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (salida != null) {
                salida.close();
            }
        }
    }

    public void anexarArchivo(String nombreArchivo, String contenido) {

        File archivo = new File(nombreArchivo);
        //PrintWriter salida = null;
        try ( PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))) {
            salida.println(contenido);
            System.out.println("Anexado información");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        
        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))){
            
            String linea = entrada.readLine();
            
            while (linea != null){
                System.out.println("Leyendo " + linea);
                linea = entrada.readLine();
            }
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
