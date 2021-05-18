package principal;

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

        //Creamos computadoras:
        //Compu1 - Forma de crear objetos nro. 1
        Raton ratonGen = new Raton("USB", "Genius");
        Teclado tecladoGen = new Teclado("Bluetooth", "Genius");
        Monitor monitorGen = new Monitor("Genius", 23.5);
        Computadora compuGen = new Computadora("Computadora Genius", monitorGen, tecladoGen, ratonGen);

        //Compu2 - Forma de crear objetos nro. 2
        Computadora compuHP = new Computadora("Computadora HP",
                new Monitor("HP", 20.0),
                new Teclado("Bluetooth", "HP"),
                new Raton("USB", "HP"));

        //Creamos una orden de compra porque para un cliente1 (ficticio)
        Orden orden1 = new Orden();

        orden1.agregarComputadora(compuGen);
        orden1.agregarComputadora(compuHP);

        System.out.println(orden1.mostrarOrden());

        //Realizar otra compra:
        System.out.println("\n==SEGUNDA ORDEN==\n");
        //1 - Crear nuevas computadoras
        //Compu2 - Forma de crear objetos nro. 2
        Computadora compuHP2 = new Computadora("Computadora HP",
                new Monitor("HP", 25.5),
                new Teclado("Bluetooth", "HP"),
                new Raton("USB", "HP"));

        //Compu2 - Forma de crear objetos nro. 2
        Computadora compuLenovo = new Computadora("Computadora Lenovo",
                new Monitor("Lenovo", 45.0),
                new Teclado("USB", "Lenovo"),
                new Raton("USB", "Lenovo"));

        //2 - Crear una nueva orden para un cliente2 - orden2
        Orden orden2 = new Orden();

        //3 - Agregar las computadoras creadas en el ejercicio1 a la orden2 y mostrarlas.
        orden2.agregarComputadora(compuHP2);
        orden2.agregarComputadora(compuLenovo);

        System.out.println(orden2.mostrarOrden());

    }

}
