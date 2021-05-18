package factory;

import buttons.Button;
import buttons.WindowsButton;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
}
