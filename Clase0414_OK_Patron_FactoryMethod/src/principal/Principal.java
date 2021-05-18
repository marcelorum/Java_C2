package principal;

import factory.*;

/**
 * Demo class. Everything comes together here.
 *
 * Factory Method (También llamado: Metodo fabrica, Constructor virtual) es un
 * patron de disenio creacional que proporciona una interfaz para crear objetos
 * en una superclase, mientras permite a las subclases alterar el tipo de
 * objetos que se crearán.
 *
 * @author refactoring.guru
 */
public class Principal {

    private static Dialog dialog;

    /**
     * El codigo cliente funciona con una instancia de un creador concreto,
     * aunque a través de su interfaz base. Siempre y cuando el cliente siga
     * funcionando con el creador a traves de la interfaz base, puedes pasarle
     * cualquier subclase del creador.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ventana = "Windows"; //Windows al Sistema Operativo 
        configurar(ventana);
        ejecutarLogicaNegocio();

    }

    /**
     * La aplicación elige un tipo de creador dependiendo de la configuracion
     * actual o los ajustes del entorno.
     *
     * @param tipoVentana - define el tipo de la configuracion
     */
    public static void configurar(String tipoVentana) {
        if (tipoVentana.equals("Windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    public static void ejecutarLogicaNegocio() {
        dialog.renderWindow();
    }

}
