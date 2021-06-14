package consola;

import java.util.Scanner;
import negocio.*;

/**
 * Paquete consola - Clase Principal. La clase representa "una interfaz" con la
 * que el usuario interactúa ingresando y leyendo los datos.
 *
 * @author Angonoa, Franco.
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        menuOpciones();

    }

    public static void menuOpciones() {
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl(); //Objeto que permite comunicarme con la capa de negocio
        Scanner teclado = new Scanner(System.in);
        int opciones;

        do {
            System.out.printf("%n==MENU OPCIONES=="
                    + "%n1 - %-20s"
                    + "%n2 - %-20s"
                    + "%n3 - %-20s"
                    + "%n4 - %-20s"
                    + "%n5 - %-20s"
                    + "%n6 - %-20s"
                    + "%n0 - %-20S"
                    + "%nIngrese una opcion: ",
                    "Iniciar catalogo peliculas",
                    "Agregar peliculas",
                    "Listar peliculas",
                    "Buscar pelicula",
                    "Serializar pelicula",
                    "Deserializar pelicula",
                    "Salir");
            opciones = Integer.parseInt(teclado.nextLine());

            switch (opciones) {
                case 1:
                    System.out.printf("%s%n", catalogo.iniciarCatalogoPeliculas());
                    break;
                case 2:
//                    System.out.println("Ingresar el nombre de la pelicula: ");
//                    String nombrePelicula = teclado.nextLine();

                    //System.out.printf("%s%n", catalogo.agregarPelicula(nombrePelicula));
                    
                    System.out.printf("%s%n", catalogo.agregarPelicula("Batman"));
                    System.out.printf("%s%n", catalogo.agregarPelicula("Spiderman"));
                    System.out.printf("%s%n", catalogo.agregarPelicula("Superman"));
                    break;
                case 3:
                    System.out.printf("%s%n", catalogo.listarPeliculas());
                    break;
                case 4:
                    System.out.printf("Ingrese el nombre de la pelicula a buscar: %n");
                    String nombrePelicula = teclado.nextLine();
                    System.out.printf("%s%n", catalogo.buscarPelicula(nombrePelicula));
                    break;
                case 5:
                    System.out.println("Ingresar el nombre de la pelicula: ");
                    String peliculaSerial = teclado.nextLine();
                    
                    System.out.printf("%s%n", catalogo.serializar(peliculaSerial));
                    break;
                case 6:
                    System.out.printf("%s%n", catalogo.deserializar());
                    break;                
                case 0:
                    System.out.printf("%S%n", "Hasta pronto!");
                    break;
                default:
                    System.out.printf("La opcion %d es incorrecta%n", opciones);
            }

        } while (opciones != 0);
    }

}
