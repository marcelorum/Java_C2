package consola;

import dominio.Genero;
import static dominio.Genero.*;
import dominio.EstadoAlquiler;
import java.time.LocalDate;
import java.time.Month;
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
                    + "%n1 - %s"
                    + "%n2 - %s"
                    + "%n3 - %s"
                    + "%n4 - %s"
                    + "%n5 - %s"
                    + "%n6 - %s"
                    + "%n0 - %s"
                    + "%nIngrese una opcion: ", "Agregar pelicula", "Listar peliculas", "Buscar Peliculas", "Borrar pelicula", "Mostrar Nombre de Pelicula", "Aplicar Filtros", "Salir");
            opciones = Integer.parseInt(teclado.nextLine());

            switch (opciones) {
                case 1:
//                    System.out.println("Ingrese el nombre de la pelicula: ");
//                    String nombre = teclado.nextLine();
//
//                    LocalDate fecha = ingresarFecha();
//                    Genero genero = ingresarGenero();
//                    EstadoAlquiler estado = ingresarEstadoAlquiler();
//                    
//                    catalogo.agregarPelicula(nombre, fecha, genero, estado); //Nos comunicamos con la capa de negocio con esta llamada.                    
                    catalogo.agregarPelicula("Mortal Kombat", LocalDate.of(2021, Month.APRIL, 23), ACCION, EstadoAlquiler.NO_DISPONIBLE);
                    //catalogo.agregarPelicula("Mortal Kombat", LocalDate.of(2021, Month.APRIL, 23), ACCION, EstadoAlquiler.NO_DISPONIBLE);
                    catalogo.agregarPelicula("Godzilla vs Kong", LocalDate.of(2021, Month.MARCH, 25), CIENCIA_FICCION, EstadoAlquiler.DISPONIBLE);
                    catalogo.agregarPelicula("En guerra con mi abuelo", LocalDate.of(2021, Month.APRIL, 15), COMEDIA, EstadoAlquiler.ALQUILADO);
                    catalogo.agregarPelicula("Raya y el ultimo dragon", LocalDate.of(2021, Month.MARCH, 3), ACCION, EstadoAlquiler.ALQUILADO);
                    catalogo.agregarPelicula("Los nuevos mutantes", LocalDate.of(2020, Month.NOVEMBER, 26), TERROR, EstadoAlquiler.DISPONIBLE);
                    catalogo.agregarPelicula("Pinocho", LocalDate.of(2019, Month.APRIL, 8), DRAMA, EstadoAlquiler.ALQUILADO);
                    break;
                case 2:
                    System.out.printf("%S%n", catalogo.listarPeliculas());
                    break;
                case 3:
                    System.out.printf("Ingrese el nombre de la pelicula a buscar: %n");
                    String nombrePelicula = teclado.nextLine();
                    System.out.printf("%s%n", catalogo.buscarPelicula(nombrePelicula));
                    break;
                case 4:
                    System.out.printf("Ingrese el nombre de la pelicula a borrar: %n");
                    String peliculaBorrar = teclado.nextLine();
                    catalogo.borrarPelicula(peliculaBorrar);
                    break;
                case 5:
                    System.out.printf("[%s]%n", catalogo.mostrarNombresPeliculas());
                    break;
                case 6:
                    System.out.printf("[%s%n]", catalogo.aplicarFiltro());
                    break;
                case 0:
                    System.out.printf("%S%n", "Hasta pronto!");
                    break;
                default:
                    System.out.printf("La opción %d es incorrecta %n", opciones);
            }

        } while (opciones != 0);
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

    /**
     * Opcion nro 1 Cargar un genero. Este metodo permite solicitar al usuario
     * los datos para cargar un genero de una pelicula.
     *
     * @return genero de la pelicula.
     */
    public static Genero ingresarGenero() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresar el numero de genero:"
                + "\n1 - Accion\t2 - Comedia\t3 - Drama"
                + "\n4 - Terror\t5 - Musical\t6 - Ciencia ficcion"
                + "\n7 - Guerra");
        int nroGenero = Integer.parseInt(teclado.nextLine());

        switch (nroGenero) {
            case 1:
                return ACCION; //Para usar solo la constante, se debe usar el import static
            case 2:
                return COMEDIA;
            case 3:
                return DRAMA;
            case 4:
                return TERROR;
            case 5:
                return MUSICAL;
            case 6:
                return CIENCIA_FICCION;
            case 7:
                return GUERRA;
            default:
                return null;
        }

    }

    /**
     * Opcion nro 1 Cargar un estado de alquiler. Este metodo permite solicitar
     * al usuario los datos para cargar un estado de alquiler de una pelicula.
     *
     * @return estado de alquiler.
     */
    public static EstadoAlquiler ingresarEstadoAlquiler() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresar el numero del estado de alquiler:"
                + "\n1 - Disponible\t2 - No disponible\t3 - Alquilado");
        int nroEstado = Integer.parseInt(teclado.nextLine());

        switch (nroEstado) {
            case 1:
                return EstadoAlquiler.DISPONIBLE;
            case 2:
                return EstadoAlquiler.NO_DISPONIBLE;
            case 3:
                return EstadoAlquiler.ALQUILADO;
            default:
                return null;
        }

    }

}
