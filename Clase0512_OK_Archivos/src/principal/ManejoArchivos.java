package principal;

import java.io.*;

/**
 *
 * @author Franco
 */
public class ManejoArchivos {
    //SIN CAMPOS

    //METODOS
    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        
        try (PrintWriter salida = new PrintWriter(archivo)) {
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;

        try {
            salida = new PrintWriter(archivo);
            salida.println(contenido);
            System.out.println("Se ha escrito en el archivo.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (salida != null) {
                salida.close();
            }
        }
    }

    public static void anexarArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);

        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))) {
            salida.println(contenido);
            System.out.println("Se ha anexado la informacion");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {

            String linea = entrada.readLine();

            while (linea != null) {
                System.out.println("Archivo: " + linea);
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
