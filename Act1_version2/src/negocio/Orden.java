package negocio;

import entidad.Computadora;


/**
 * Clase Orden. Encargada de manejar toda la logica de negocio o del programa.
 *
 * @author Angonoa, Franco.
 */
public class Orden {

    //CAMPOS
    private final int ID_ORDEN;
    private static int contadorOrdenes; //Campo DE LA CLASE. Funcion: contar la cantidad de objetos de tipo Orden.
    private Computadora[] computadoras; //Arreglo de Computadora que se almacenan para una orden.
    private int contadorComputadoras; //Cantidad de computadoras en una orden.
    private static final int MAX_COMPUTADORAS = 10; 

    //CONSTRUCTOR
    public Orden() {
        this.ID_ORDEN = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }

    //METODOS
    public void agregarComputadora(Computadora computadora) {

        if (this.contadorComputadoras < Orden.MAX_COMPUTADORAS) {
            //Agreguemos
            this.computadoras[this.contadorComputadoras++] = computadora;
        } else {
            System.out.println("Se supero el limite de computadoras: " + Orden.MAX_COMPUTADORAS);
        }
    }

    public String mostrarOrden() {
        String listado = "Nro. de Orden: " + this.ID_ORDEN;

        listado += "\n[\n";

        for (Computadora unaComputadora : computadoras) {
            if (unaComputadora != null) {
                listado += unaComputadora + "\n";
            }
        }

        listado += "]";

        return listado;
    }

}
