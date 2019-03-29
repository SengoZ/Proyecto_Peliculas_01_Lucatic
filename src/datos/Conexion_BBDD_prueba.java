package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Conexion_BBDD_prueba {

	private static Connection con = null;
	// JDBC Driver Name & Database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    //private static final String JDBC_DB_URL = "jdbc:mysql://localhost/movie_flix"; // PON LA BASE DE DATOS LOCAL!!!!!!!!!!!!!
    private static final String JDBC_DB_URL = "jdbc:mysql://192.168.101.112:3306/movie_flix"; //-> -> Base de datos general, tocar lo menos posible
    //private static final String JDBC_DB_URL = "jdbc:mysql://localhost/movie_flix"; //-> -> Base de datos general, tocar lo menos posible
    
    // JDBC Database Credentials
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";

    final static Logger log = LogManager.getLogger("BBDD");

    public static Connection Conecta_BBDD() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			log.error("--->" +"Error al insertar el tipo de dato");
		}
		return con;
	}
}
