package ConexionSQL;
// Importar librería de Java para SQL
import java.sql.*;
/**
* Crear la clase de Conexión SQL
* lleva método main[] propio
**/
public class ConexionSQL {
/**• Main()
* params args[]
**/
 public static void main(String[] args) {
 // String de Conexión por URL
 String url =
"jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=PruebaConexion;encrypt=false;trustServerCertificate=true;";
 String usuario = "usuario";
 String contraseña = "123456";
 // Intentar conectarse al SQL Server
 try {
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
 System.out.println("✓ Conexión exitosa");
 // Hacer la consulta SQL
 Statement stmt = conexion.createStatement();
 ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios");
 // Mostrar datos de la tabla
 while (rs.next()) {
 System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre")+", Fecha: " + rs.getString("Fecha"));
 }
 // Cerrar conexión, consulta y estado
 rs.close();
 stmt.close();
 conexion.close();
 // En caso de errores, imprime un mensaje de error
 } catch (Exception e) {
 System.out.println("❌ Error de conexión: " + e.getMessage());
 }
 }
}
