package principal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Principal {
    
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/javabd?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
        Connection conn = DriverManager.getConnection(url, "root", "root");
    }
}
