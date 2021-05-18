package principal;

import negocio.Orden;
import entidad.*;
import java.util.Scanner;

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

        // Creamos compus
        //Compu1
//        Raton ratonGen = new Raton("USB", "Genius");
//        Teclado tecladoGen = new Teclado("BT", "Genius");
//        Monitor monitorLG = new Monitor("LG", 22);
//        Computadora compuGen = new Computadora("Compu Genius", monitorLG, tecladoGen, ratonGen);
        //Compu2
        //Computadora compuHP = new Computadora("Compu HP", new Monitor("HP", 24), new Teclado("USB", "HP"), new Raton("BT", "HP"));
        // Creamos una orden de compra
//        Orden orden1 = new Orden();
//
//        orden1.agregarComputadora(compuGen);
//        orden1.agregarComputadora(compuHP);
//
//        System.out.println(orden1.mostrarOrden());
    }

    public static void menuOpciones() {

        Scanner teclado = new Scanner(System.in);
        int opcion;
        Orden orden = null;

        do {
            System.out.println("==MENU==");
            System.out.println("1 - Cargar");
            System.out.println("2 - Mostrar");
            System.out.println("3 - Crear otra orden");
            System.out.println("4 - Salir");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    Computadora compuAux = nuevaComputadora();
                    orden.agregarComputadora(compuAux);
                    //orden.agregarComputadora(nuevaComputadora());
                    break;
                case 2:
                    System.out.println(orden.mostrarOrden());
                    break;
                case 3:
                    orden = new Orden();
                    break;
                case 4:
                    System.out.println("Chau, gracias");
            }

        } while (opcion != 4);
    }

    public static Computadora nuevaComputadora() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el tipo de entrada del RATON: ");
        String tipoEntradaR = teclado.nextLine();

        System.out.println("Ingrese la marca del RATON: ");
        String marcaR = teclado.nextLine();

        Raton raton = new Raton(tipoEntradaR, marcaR);

        System.out.println("Ingrese el tipo de entrada del TECLADO: ");
        String tipoEntradaT = teclado.nextLine();

        System.out.println("Ingrese la marca del TECLADO: ");
        String marcaT = teclado.nextLine();

        Teclado tecladoObj = new Teclado(tipoEntradaT, marcaT);

        System.out.println("Ingrese la marca del MONITOR: ");
        String marcaM = teclado.nextLine();

        System.out.println("Ingrese el tamanio del MONITOR: ");
        double tamanioM = Double.parseDouble(teclado.nextLine());

        Monitor monitor = new Monitor(marcaM, tamanioM);

        System.out.println("Ingrese el nombre de la COMPUTADORA: ");
        String nombreC = teclado.nextLine();

        Computadora computadora = new Computadora(nombreC, monitor, tecladoObj, raton);

        return computadora;

    }

}
