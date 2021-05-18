package consola;

import dominio.EstadoAlquiler;
import static dominio.Genero.*;
import java.util.Date;
import java.util.Scanner;
import negocio.*;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuOpciones();
    }

    public static void menuOpciones() {
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        Scanner teclado = new Scanner(System.in);
        int opciones = -1;

        do {
            System.out.println("1 - Iniciar Catálogo"
                    + "\n2 - Agragar película"
                    + "\n3 - Listar películas"
                    + "\n4 - Buscar película"
                    + "\n5 - Borrar película"
                    + "\n0 - Salir"
                    + "\nIngrese una opción: ");
            opciones = Integer.parseInt(teclado.nextLine());
            switch (opciones) {
                case 1:
                    break;
                case 2:
                    catalogo.agregarPelicula("Batman", new Date(), ACCION, EstadoAlquiler.ALQUILADO);
                    break;
                case 3:
                    System.out.println(catalogo.listarPeliculas());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Gracias!");
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
        } while (opciones != 0);

    }

}
