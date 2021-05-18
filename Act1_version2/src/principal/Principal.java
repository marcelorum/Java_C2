package principal;

import entidad.Raton;
import negocio.Orden;
import entidad.*;
import java.util.Scanner;

/**
 * Clase Principal. Contenedor del metodo main. Toman los datos de un usuario.
 *
 * @author Angonoa Franco
 * @version 1.0
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        menuOpciones();

    }

    public static void menuOpciones() {

        Scanner teclado = new Scanner(System.in);
        int opcion;
        Orden orden = null; //Declarando

        do {
            System.out.println("==MENU OPCIONES==");
            System.out.println("1 - Cargar computadora");
            System.out.println("2 - Mostrar orden");
            System.out.println("3 - Crear otra Orden");
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
                    orden = new Orden(); //Instanciando
                    System.out.println("Orden creada!");
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el programa");
            }

        } while (opcion != 4);

    }
    
    public static Computadora nuevaComputadora(){
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
