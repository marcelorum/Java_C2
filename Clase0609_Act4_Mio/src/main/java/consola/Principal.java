package consola;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import negocio.*;

/**
 * Paquete consola - Clase Principal. La clase representa "una interfaz" con la
 * que el usuario interactúa ingresando y leyendo los datos.
 *
 * @author Angonoa, Franco.
 */
public class Principal {

    public static Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        menuOpciones();

    }

    public static void menuOpciones() {
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl(); //Objeto que permite comunicarme con la capa de negocio        
        int opciones;

        do {
            System.out.printf("%n==MENU OPCIONES=="
                    + "%n1 - %-20s"
                    + "%n2 - %-20s"
                    + "%n3 - %-20s"
                    + "%n4 - %-20s"
                    + "%n5 - %-20s"
                    + "%n0 - %-20S"
                    + "%nIngrese una opcion: ",
                    "Agregar peliculas",
                    "Listar peliculas",
                    "Modificar pelicula",
                    "Borrar pelicula",
                    "Buscar pelicula",
                    "Salir");
            opciones = Integer.parseInt(teclado.nextLine());

            switch (opciones) {
                case 1:
                    Map<String, Object> datosPeliculaNueva = pedirDatos();
                    System.out.printf("Cantidad de peliculas agregadas: %d%n", catalogo.agregarPelicula(datosPeliculaNueva.get("nombre").toString(), (LocalDate) datosPeliculaNueva.get("fecha"), datosPeliculaNueva.get("genero").toString())); //Nos comunicamos con la capa de negocio con esta llamada.                    

                    break;
                case 2:
                    System.out.println(catalogo.listarPeliculas());
                    break;
                case 3:
                    System.out.println("Ingrese el id de la pelicula: ");
                    int idPelicula = Integer.parseInt(teclado.nextLine());
                    Map<String, Object> datosPeliculaMod = pedirDatos();
                    System.out.printf("Cantidad de peliculas modificadas: %d%n", catalogo.modificarPelicula(idPelicula, datosPeliculaMod.get("nombre").toString(), (LocalDate) datosPeliculaMod.get("fecha"), datosPeliculaMod.get("genero").toString()));
                    break;
                case 4:
                    System.out.println("Ingrese el id de la pelicula: ");
                    int idPeliculaBorrar = Integer.parseInt(teclado.nextLine());
                    System.out.printf("Cantidad de peliculas borradas: %d%n", catalogo.borrarPelicula(idPeliculaBorrar));
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opciones != 0);
    }

    /**
     * La funcion de este metodo es pedir los datos basicos para cargar una
     * pelicula. Como lo es el nombre, fecha y genero.
     *
     * @return Map que tiene como key un String y como value un Object.
     */
    public static Map<String, Object> pedirDatos() {
        Map<String, Object> datosPelicula = new HashMap<>();

        System.out.println("Ingrese el nombre de la pelicula: ");
        String nombre = teclado.nextLine();
        datosPelicula.put("nombre", nombre);

        LocalDate fecha = ingresarFecha();
        datosPelicula.put("fecha", fecha);

        System.out.println("Ingrese el genero de la pelicula: ");
        String genero = teclado.nextLine();
        datosPelicula.put("genero", genero);

        return datosPelicula;
    }

    /**
     * Opcion nro 1 Cargar una fecha. Este metodo permite solicitar al usuario
     * los datos para crear una fecha y cargarla como fecha de lanzamiento de
     * una pelicula.
     *
     * @return fecha de lanzamiento.
     */
    public static LocalDate ingresarFecha() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresar el anio de extreno: ");
        int anio = Integer.parseInt(teclado.nextLine());

        System.out.println("Ingresar el numero del mes:"
                + "\n1 - Enero\t2 - Febrero\t3 - Marzo"
                + "\n4 - Abril\t5 - Mayo\t6 - Junio"
                + "\n7 - Julio\t8 - Agosto\t9 - Septiembre"
                + "\n10 - Octubre\t11 - Noviembre\t12 - Diciembre");
        int nroMes = Integer.parseInt(teclado.nextLine());
        Month mes = Month.of(nroMes);

        System.out.println("Ingresar el dia de extreno: ");
        int dia = Integer.parseInt(teclado.nextLine());

        return LocalDate.of(anio, mes, dia);
    }

}
