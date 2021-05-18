package botones;

/**
 * HTML button implementation. Los productos concretos proporcionan varias
 * implementaciones de la interfaz de producto.
 *
 * @author refactoring.guru
 */
public class HtmlBoton implements IBoton {

    /**
     * Devuelve una representación HTML de un botón.
     */
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    /**
     * Vincula un evento clic de navegador web.
     */
    @Override
    public void onClick() {
        System.out.println("Click! Boton dice: 'Hola Mundo!'");
    }

}
