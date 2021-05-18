package factory;

import buttons.Button;
import buttons.HtmlButton;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
    
}
