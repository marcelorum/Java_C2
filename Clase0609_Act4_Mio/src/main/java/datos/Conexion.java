package datos;

import java.sql.*;

public class Conexion {

    // UTC: Universal Time Coordinated
    // GMT-3: Argentina
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/actividadcuatrobd?useSSL=false&useTimezone=true&serverTimezone=GMT-3&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "bo3ken5u";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
        
}
