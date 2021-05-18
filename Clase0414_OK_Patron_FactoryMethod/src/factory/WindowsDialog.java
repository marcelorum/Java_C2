package factory;

import botones.IBoton;
import botones.WindowsBoton;

/**
 * Windows Dialog will produce Windows buttons. Los creadores concretos
 * sobrescriben el metodo fabrica para cambiar el tipo de producto resultante
 *
 * @author refactoring.guru
 */
public class WindowsDialog extends Dialog {

    @Override
    public IBoton crearBoton() {
        return new WindowsBoton();
    }

}
