package principal;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Singleton {
    
    // CAMPOS PARA SINGLETON
    private static Singleton instance;
    
    
    // CAMPOS PROPIOS
    public String value;
    
    // CONSTRUCTOR PRVADO
    private Singleton(String value){
        this.value = value;
    }
    
    public static Singleton getInstance(String value){
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    } 
    
}
