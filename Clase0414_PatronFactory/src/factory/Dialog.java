package factory;

import buttons.Button;



/**
 *
 * @author Marce marcelorum@gmail.com
 */
public abstract class Dialog {
    
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
        
    }
    public abstract Button createButton();
    
    
    
}
