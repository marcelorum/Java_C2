package datos;

import static datos.Conexion.*;
import dominio.Pelicula;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class AccesoDatosBD implements IAccesoDatos {

    @Override
    public List<Pelicula> listar() throws SQLException{

        return null;
    }

    
    @Override
    public int guardar(Pelicula pelicula) throws SQLException{

        return 0;
    }

    
    @Override
    public int modificar(Pelicula pelicula) throws SQLException{

        return 0;
    }

    @Override
    public int borrar(Pelicula pelicula) throws SQLException{

        return 0;
    }

    @Override
    public Pelicula buscarPelicula(Pelicula pelicula) throws SQLException {
        return null;
    }
    
}
