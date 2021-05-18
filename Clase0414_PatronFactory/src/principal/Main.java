package principal;

import factory.Dialog;
import factory.HtmlDialog;
import factory.WindowsDialog;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Main {
    
    private static Dialog dialog;

    public static void main(String[] args) {
        String ventana = "Windows"; //Windows al SO
        configure();
        runBusinessLogic();
    }
    static void configure() {
        //if (tipoVentana.equals = Windows) {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            //dialog = new HtmlDialog();
            dialog = new WindowsDialog();
        }
    }
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
    
}
