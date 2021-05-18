package negocio;

import entidad.Computadora;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Orden {
    
    // CAMPOS
    private final int ID_ORDEN;
    private static int contadorOrdenes;
    private Computadora[] computadoras;
    private int contadorComputadoras;
    private static final int MAX_COMPUTADORAS = 10;
    
    //CONSTRUCTORES
    public Orden(){
        this.ID_ORDEN = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }
    
    //METODOS
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.MAX_COMPUTADORAS){
            //Agregamos
            this.computadoras[this.contadorComputadoras++] = computadora;
        }else{
            System.out.println("Se superó el límite: " + Orden.MAX_COMPUTADORAS);
        }
    }
    
    public String mostrarOrden(){
        String listado = " Nro. de Orden: " + this.ID_ORDEN;
        listado += "[";
        for (Computadora unaComputadora : computadoras) {
            listado += unaComputadora + "\n";
        }
        listado += "}";
        return listado;
    }
    
}
