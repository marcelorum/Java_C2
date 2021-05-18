package principal;

/**
 * Singleton es un patron de disenio creacional que nos permite asegurarnos de
 * que una clase tenga una unica instancia, a la vez que proporciona un punto de
 * acceso global a dicha instancia.
 *
 * @author refactoring.guru
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n"
                + "If you see different values, then 2 singletons were created (booo!!)" + "\n\n"
                + "RESULT:" + "\n");

        BaseDatosSingleton bdSQL = BaseDatosSingleton.getInstancia("jdbc::sql");
        BaseDatosSingleton bdMySQL = BaseDatosSingleton.getInstancia("jdbc::MYsql");
        //La variable 'bdSQL' contendra el mismo objeto que la variable 'bdMySQL'.

        System.out.println(bdSQL.toString() + " hashCode: " + bdSQL.hashCode());
        System.out.println(bdMySQL.toString() + " hashCode: " + bdMySQL.hashCode());

    }

}
