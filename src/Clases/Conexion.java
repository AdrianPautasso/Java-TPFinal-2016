package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion{
      
    @SuppressWarnings("finally")
	public static Connection GetConnection()
    {
        Connection conexion=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/cajero";
            String usuarioDB="root";
            String passwordDB="";            
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
        }
        catch(ClassNotFoundException ex)
        {
            conexion=null;
        }
        catch(SQLException ex)
        {
            conexion=null;
        }
        catch(Exception ex)
        {
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
}
