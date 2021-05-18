package factory;

import botones.HtmlBoton;
import botones.IBoton;

/**
 * HTML Dialog will produce HTML buttons. Los creadores concretos sobrescriben
 * el metodo fabrica para cambiar el tipo de producto resultante
 *
 * @author refactoring.guru
 */
public class HtmlDialog extends Dialog {

    @Override
    public IBoton crearBoton() {
        return new HtmlBoton();
    }

}
