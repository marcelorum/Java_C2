package datos;

import static datos.Conexion.*;
import dominio.Pelicula;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class AccesoDatosBD implements IAccesoDatos {
    
    // CAMPOS
    private static final String SQL_SELECT = "SELECT * FROM actividadcuatrobd.pelicula";
    private static final String SQL_INSERT = "INSERT INTO actividadcuatrobd.pelicula(nombre, fecha, genero) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE actividadcuatrobd.pelicula SET nombre=?, fecha=?, genero=? WHERE idPelicula=?";
    private static final String SQL_DELETE = "DELETE FROM actividadcuatrobd.pelicula WHERE idPelicula=?";
    
    @Override
    public List<Pelicula> listar() throws SQLException{
        List<Pelicula> peliculas = new ArrayList<>();
        Pelicula pelicula = null;
        
        try(Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_SELECT);
                ){
            
            while(rs.next()){
                int idPelicula = rs.getInt("idPelicula");
                String nombre = rs.getString("nombre");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                String genero = rs.getString("genero");
                
                pelicula = new Pelicula(idPelicula, nombre, fecha, genero);
                peliculas.add(pelicula);
                
            }
        }
        return peliculas;
    }

    
    @Override
    public int guardar(Pelicula pelicula) throws SQLException{
        int cantidadRegistros = 0;
        
        try(
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
                ){
            // Cargar valores para los argumentos
            stmt.setString(1, pelicula.getNombre());
            stmt.setDate(2, java.sql.Date.valueOf(pelicula.getFechaLanzamiento()));
            stmt.setString(3, pelicula.getGenero());
            
            // Ejecutar sentencia
            cantidadRegistros = stmt.executeUpdate();
        }
        return cantidadRegistros;
    }

    
    @Override
    public int modificar(Pelicula pelicula) throws SQLException{
        int cantidadRegistros = 0;
        
        try(
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
                ){
            // Cargar valores a los argumentos
            stmt.setString(1, pelicula.getNombre());
            stmt.setDate(2, java.sql.Date.valueOf(pelicula.getFechaLanzamiento()));
            stmt.setString(3, pelicula.getGenero());
            stmt.setInt(4, pelicula.getIdPelicula());
            // Ejecutar sentencia
            cantidadRegistros = stmt.executeUpdate();
        }
        
        return cantidadRegistros;
    }

    @Override
    public int borrar(Pelicula pelicula) throws SQLException{
        int cantidadRegistros = 0;
        
        try(
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
                ){
            // Cargar valores
            stmt.setInt(1, pelicula.getIdPelicula());
            // Ejecutar sentencia
            cantidadRegistros = stmt.executeUpdate();
        }
        return cantidadRegistros;
    }

    @Override
    public Pelicula buscarPelicula(Pelicula pelicula) throws SQLException {
        return null;
    }
    
}
